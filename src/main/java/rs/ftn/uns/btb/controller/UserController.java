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
import rs.ftn.uns.btb.model.User;
import rs.ftn.uns.btb.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    public final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Operation(summary = "Create new user", description = "Create new user", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "409", description = "Not possible to create new user when given ID is not null",
                    content = @Content)
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = null;
        try {
            savedUser = userService.create(user);
            return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<User>(savedUser, HttpStatus.CONFLICT);
        }
    }

}
