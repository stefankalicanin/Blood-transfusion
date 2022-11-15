package rs.ftn.uns.btb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ftn.uns.btb.model.Center;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import rs.ftn.uns.btb.model.dto.CenterUpdateDTO;
import rs.ftn.uns.btb.service.CenterService;

@Tag(name = "Center controller", description = "The Center API")
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/api/center")
public class CenterController {

    public final CenterService _centerService;

    @Autowired
    public CenterController(CenterService _centerService) { this._centerService = _centerService; }

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
            savedCenter = _centerService.create(center);
            savedCenter = center;
            return new ResponseEntity<Center>(savedCenter, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Center>(savedCenter, HttpStatus.CONFLICT);
        }
    }

    @Operation(summary = "Update an existing center", description = "Update an existing center desc", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Center successfully edited",
                    content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = Center.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Center not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Center> updateCenter(@PathVariable Long id, @RequestBody CenterUpdateDTO centerUpdateDTO) {
        Center centerForUpdate = _centerService.findOne(id);

        centerForUpdate.copyValuesFromDTO(centerUpdateDTO);

        Center updatedCenter = null;

        try {
            updatedCenter = _centerService.update(centerForUpdate);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Center>(HttpStatus.NOT_FOUND);
        }

        if (updatedCenter == null) {
            return new ResponseEntity<Center>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Center>(updatedCenter, HttpStatus.OK);

    }
}
