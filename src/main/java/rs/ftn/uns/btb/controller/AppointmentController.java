package rs.ftn.uns.btb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ftn.uns.btb.model.Appointment;
import rs.ftn.uns.btb.model.dto.AppointmentDTO;
import rs.ftn.uns.btb.service.AppointmentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/appointment")
public class AppointmentController {

    public final AppointmentService _appointmentService;

    @Autowired
    public AppointmentController(AppointmentService _appointmentService) { this._appointmentService = _appointmentService; }

    // value = "/byCenter/1"

    @Operation(summary = "Get appointments for given center id", description = "Get appointments for given center id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "found appointments for center by id",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Appointment.class))),
            @ApiResponse(responseCode = "404", description = "appointments not found", content = @Content)
    })
    @GetMapping(value = "/byCenter/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsByCenter(@Parameter(name="id", description = "ID of a center to return", required = true) @PathVariable("id") Long id) {
        List<Appointment> appointments = _appointmentService.findByCenterId(id);
        List<AppointmentDTO> appointmentDTOS = new ArrayList<AppointmentDTO>();
        for (Appointment app : appointments) {
            AppointmentDTO tempAppDTO = new AppointmentDTO();
//            System.out.println("App ID: " + app.getId());
            tempAppDTO.copyValues(app);
            appointmentDTOS.add(tempAppDTO);
        }

        if (appointmentDTOS == null) {
            return new ResponseEntity<List<AppointmentDTO>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<AppointmentDTO>>(appointmentDTOS, HttpStatus.OK);
    }

}
