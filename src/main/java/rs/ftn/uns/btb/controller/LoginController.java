package rs.ftn.uns.btb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ftn.uns.btb.model.Admin;
import rs.ftn.uns.btb.model.User;
import rs.ftn.uns.btb.model.dto.LoginDTO;
import rs.ftn.uns.btb.model.dto.UserLoginDTO;
import rs.ftn.uns.btb.service.AdminService;
import rs.ftn.uns.btb.service.LoginService;
import rs.ftn.uns.btb.service.StaffService;
import rs.ftn.uns.btb.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/login")
public class LoginController {

    public final LoginService _userService;

    @Autowired
    public LoginController(LoginService _userService) { this._userService = _userService; }

    @Operation(summary = "Login", description = "Login", method="GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully logged in!",
                    content =
                            { @Content(mediaType = "application/json", schema = @Schema(implementation = LoginDTO.class)) }
            ),
            @ApiResponse(responseCode = "404", description = "Invalid username or password", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginDTO> checkLogin(@RequestBody UserLoginDTO loginDTO) {
        System.out.println(loginDTO.getEmail() + " :" + loginDTO.getPassword() );

        LoginDTO login_info = _userService.checkLogin(loginDTO.getEmail(), loginDTO.getPassword());
        System.out.println("User check Login returned: " + login_info );
        if (login_info == null) {
            return new ResponseEntity<LoginDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LoginDTO>(login_info, HttpStatus.OK);
    }

}
