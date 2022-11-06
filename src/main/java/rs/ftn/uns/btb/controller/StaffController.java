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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ftn.uns.btb.model.Staff;
import rs.ftn.uns.btb.model.Person;
import rs.ftn.uns.btb.service.StaffService;

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

}