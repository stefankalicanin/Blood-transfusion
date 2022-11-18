package rs.ftn.uns.btb.core.center;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import rs.ftn.uns.btb.core.center.dtos.CenterUpdateDTO;
import rs.ftn.uns.btb.core.center.interfaces.CenterService;

import java.util.ArrayList;
import java.util.List;






@CrossOrigin(origins = "*")

@Tag(name = "Center controller", description = "The Center API")
@RestController
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
//            savedCenter = center;
            return new ResponseEntity<Center>(savedCenter, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Center>(savedCenter, HttpStatus.CONFLICT);
        }
    }
    @Operation(summary = "Get all center", description = "Get all center", method="GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Center.class))))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CenterUpdateDTO>> getCenter() {
        List<Center> centers = _centerService.findAll();
        List<CenterUpdateDTO> centerDTO = new ArrayList<>();
        for (Center c :centers)
        {
            centerDTO.add(new CenterUpdateDTO(c.getId(),c.getName(),c.getAddress(),c.getDescription(),c.getGrade()));
        }
        return new ResponseEntity<>(centerDTO, HttpStatus.OK);
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

    @GetMapping(value= "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Center>> findAll(){
        return new ResponseEntity<List<Center>>(_centerService.findAll(), HttpStatus.OK );
    }


    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Center>> search(@RequestParam String name, @RequestParam String address, @RequestParam double grade){
        return new ResponseEntity<List<Center>>(_centerService.findByNameAndAddress(name.trim(), address.trim(), grade), HttpStatus.OK);}

    @Operation(summary = "Get center by id", description = "Get center by id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "found center by id",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Center.class))),
            @ApiResponse(responseCode = "404", description = "center not found", content = @Content)
    })

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Center> getCenter(@Parameter(name="id", description = "ID of a center to return", required = true) @PathVariable("id") Long id) {
        Center center = _centerService.findOne(id);

        if (center == null) {
            return new ResponseEntity<Center>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Center>(center, HttpStatus.OK);

    }

}
//    @Operation(summary = "Get only center info by id", description = "Get only center info by id", method = "GET")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "found info for center by id",
//                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CenterInfoDTO.class))),
//            @ApiResponse(responseCode = "404", description = "info for center not found", content = @Content)
//    })
//    @GetMapping(value = "/info/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<CenterInfoDTO> getCenterInfo(@Parameter(name="id", description = "ID of a center to return", required = true) @PathVariable("id") Long id) {
//        Center center = _centerService.findOne(id);
//
//        if (center == null) {
//            return new ResponseEntity<Center>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Center>(center, HttpStatus.OK);
//    }

