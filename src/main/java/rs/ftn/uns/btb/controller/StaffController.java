package rs.ftn.uns.btb.controller;


import io.swagger.v3.oas.annotations.Operation;
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
import rs.ftn.uns.btb.model.Person;
import rs.ftn.uns.btb.model.dto.StaffDTO;
import rs.ftn.uns.btb.service.StaffService;

import javax.print.attribute.standard.Media;

@RestController
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
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody StaffDTO staffDTO) {
        Staff staffForUpdate = _staffService.findOne(id);

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

}
