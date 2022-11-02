package rs.ftn.uns.btb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import rs.ftn.uns.btb.model.Center;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Center controller", description = "The Center API")
@RestController
@RequestMapping(value = "/api/center")
public class CenterController {

    // TODO: Ispraviti POST za Center dodavanjem service-a itd.
    @Operation(summary = "Create new center", description = "Create new center", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                         content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Center.class)) }),
            @ApiResponse(responseCode = "409", description = "Not possible to create new center when given ID is not null",
                         content = @Content)
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Center> createCenter(@RequestBody Center center) {
        Center savedCenter = null;
        try {
            //savedCenter = centerService.create(center);
            savedCenter = center;
            return new ResponseEntity<Center>(savedCenter, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Center>(savedCenter, HttpStatus.CONFLICT);
        }
    }
}
