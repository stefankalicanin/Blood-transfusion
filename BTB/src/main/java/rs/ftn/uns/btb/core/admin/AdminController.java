package rs.ftn.uns.btb.core.admin;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.ftn.uns.btb.core.admin.dtos.ChangeAdminPasswordDTO;
import rs.ftn.uns.btb.core.admin.interfaces.AdminService;

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
    @PreAuthorize("hasRole('ADMIN')")
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
    
    @Operation(summary = "Update admin password", description = "Update admin password", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Admin successfuly edited",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Admin.class) )
                    }),

            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    }

    )
    @PutMapping(value="/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Admin> updateUser(@RequestBody ChangeAdminPasswordDTO dto){
        Admin updatedAdmin=null;
        try {
            updatedAdmin = _adminService.updateByPassword(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(updatedAdmin == null){
            return new ResponseEntity<Admin>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Admin>(updatedAdmin, HttpStatus.OK);

    }

}
