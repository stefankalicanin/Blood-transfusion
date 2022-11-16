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
import rs.ftn.uns.btb.model.dto.UserUpdateDTO;
import rs.ftn.uns.btb.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/user")
public class UserController {

    public final UserService _userService;

    @Autowired
    public UserController(UserService _userService) { this._userService = _userService; }


    @Operation(summary = "Create new user summary", description = "Create new user description", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "409", description = "Not possible to create new staff when given ID is not null",
                    content = @Content )
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = null;
        try {
            savedUser = _userService.create(user);
            return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<User>(savedUser, HttpStatus.CONFLICT);
        }
    }

        @Operation(summary = "Update an existing user", description = "Update an existing user", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfuly edited",
            content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = User.class) )
            }),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    }

    )
    @PutMapping(value="/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody User user){

        System.out.println(user.getId());
        User updatedUser = null;

        try {
            updatedUser = _userService.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        if(updatedUser == null){
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);

        }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return _userService.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        System.out.println("e");
        return ResponseEntity.ok(_userService.findById(id));
    }


}
