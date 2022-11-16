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
import rs.ftn.uns.btb.model.Admin;
import rs.ftn.uns.btb.model.Staff;
import rs.ftn.uns.btb.service.AdminService;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

    public final AdminService _adminService;

    @Autowired
    public AdminController(AdminService _adminService) { this._adminService = _adminService; }

    @Operation(summary = "Create new admin", description = "Create new admin", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Admin.class)) }),
            @ApiResponse(responseCode = "409", description = "Not possible to create new admin when given ID is not null",
                    content = @Content)
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin savedAdmin = null;
        try {
            savedAdmin = _adminService.create(admin);
            return new ResponseEntity<Admin>(savedAdmin, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Admin>(savedAdmin, HttpStatus.CONFLICT);
        }
    }
}
