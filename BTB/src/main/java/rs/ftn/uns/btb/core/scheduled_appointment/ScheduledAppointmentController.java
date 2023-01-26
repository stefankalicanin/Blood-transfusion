package rs.ftn.uns.btb.core.scheduled_appointment;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import rs.ftn.uns.btb.core.appointment.interfaces.AppointmentState;
import rs.ftn.uns.btb.core.scheduled_appointment.dtos.ScheduledAppointmentsViewDTO;
import rs.ftn.uns.btb.core.scheduled_appointment.interfaces.ScheduledAppointmentService;

@RestController
@RequestMapping(value = "/api/schedule")
public class ScheduledAppointmentController {

    public final ScheduledAppointmentService _sAppointmentService;

    @Autowired
    public ScheduledAppointmentController(ScheduledAppointmentService _sAppointmentService) {
        this._sAppointmentService = _sAppointmentService;
    }

    @Operation (summary = "Get appointments scheduled by user with given id", description = "Get appointments scheduled by requested user", method = "GET")
    @ApiResponses (value = {
            @ApiResponse (responseCode = "200", description = "found scheduled appointments for requested user",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ScheduledAppointment.class))),
            @ApiResponse (responseCode = "404", description = "appointments not found", content = @Content)
    })
    @GetMapping(value = "/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('STAFF')")
    public ResponseEntity<Set<ScheduledAppointmentsViewDTO>> getUsersScheduledAppointments (@Parameter(name = "user_id", description = "ID of a user", required = true) @PathVariable("user_id") Long user_id) {
        Set<ScheduledAppointment> scheduledAppointments = _sAppointmentService.findByUserId(user_id);
        Set<ScheduledAppointmentsViewDTO> scheduledAppointmentsDTO = new HashSet<ScheduledAppointmentsViewDTO>();

        for (ScheduledAppointment sApp : scheduledAppointments) {
            if (sApp.getAppointment().getState() != AppointmentState.FINISHED) {
                ScheduledAppointmentsViewDTO tempSAppDTO = new ScheduledAppointmentsViewDTO();
                tempSAppDTO.copyValues(sApp);
                scheduledAppointmentsDTO.add(tempSAppDTO);
            }
        }

        if (scheduledAppointmentsDTO.isEmpty()) {
            return new ResponseEntity<Set<ScheduledAppointmentsViewDTO>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Set<ScheduledAppointmentsViewDTO>>(scheduledAppointmentsDTO, HttpStatus.OK);

    }
    
}
