package rs.ftn.uns.btb.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ftn.uns.btb.model.Staff;
import rs.ftn.uns.btb.model.dto.StaffDTO;
import rs.ftn.uns.btb.model.dto.StaffUpdateDTO;
import rs.ftn.uns.btb.model.dto.StaffViewDTO;
import rs.ftn.uns.btb.service.StaffService;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/api/staff")
public class StaffController {

    public final StaffService _staffService;

    @Autowired
    public StaffController(StaffService _staffService) {
        this._staffService = _staffService;
    }
    @Operation(summary = "Create new staff", description = "Create new staff", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Staff.class)) }),
            @ApiResponse(responseCode = "409", description = "Not possible to create new staff when given ID is not null",
                    content = @Content)
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
        Staff savedStaff = null;
        try {
            savedStaff = _staffService.create(staff);
            return new ResponseEntity<Staff>(savedStaff, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Staff>(savedStaff, HttpStatus.CONFLICT);
        }
    }

    @Operation(summary = "Update an existing staff", description = "Update an existing staff", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Staff successfully edited",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Staff.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Staff not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody StaffUpdateDTO staffDTO) {
        Staff staffForUpdate = _staffService.findOne(id);

        if (staffDTO.getPassword() == null | staffDTO.getPassword() == "") {
            staffDTO.setPassword(staffForUpdate.getPassword());
        }
        staffForUpdate.copyValuesFromDTO(staffDTO);

        Staff updatedStaff = null;
        try {
            updatedStaff = _staffService.update(staffForUpdate);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Staff>(HttpStatus.NOT_FOUND);
        }

        if (updatedStaff == null) {
            return new ResponseEntity<Staff>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Staff>(updatedStaff, HttpStatus.OK);
    }

    @Operation(summary = "Get staff by id", description = "Get staff by id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "staff successfully found",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Staff.class))
                    }),
            @ApiResponse(responseCode = "404", description = "No staff found for given id", content = @Content) })
    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StaffDTO> getStaffById(@Parameter(name="id", description = "ID of staff to look for", required = true) @PathVariable("id") Long id) {
        Staff staff = _staffService.findOne(id);
        StaffDTO staffDTO = new StaffDTO(staff);

        if (staffDTO == null) {
            return new ResponseEntity<StaffDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<StaffDTO>(staffDTO, HttpStatus.OK);
    }

    @Operation(summary = "Get staff by center id", description = "Get all staff that work for given center id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of staff successfully found",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = StaffViewDTO.class))
                    }),
            @ApiResponse(responseCode = "404", description = "No staff found for given center id", content = @Content) })
//            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
    @GetMapping(value="byCenter/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StaffViewDTO>> getStaffByIdOfCenter(@Parameter(name="id", description = "ID of center to look staff by", required = true) @PathVariable("id") Long id) {
        List<Staff> allStaffInCenter = _staffService.findAllByCenterId(id);
        List<StaffViewDTO> staffViewDTO = new ArrayList<StaffViewDTO>();

        if (allStaffInCenter == null) {
            return new ResponseEntity<List<StaffViewDTO>>(HttpStatus.NOT_FOUND);
        }

        for (Staff staff : allStaffInCenter) {
            staffViewDTO.add(new StaffViewDTO(staff));
        }

        return new ResponseEntity<List<StaffViewDTO>>(staffViewDTO, HttpStatus.OK);
    }

}