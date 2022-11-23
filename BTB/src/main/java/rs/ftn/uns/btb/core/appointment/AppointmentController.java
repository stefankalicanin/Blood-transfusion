package rs.ftn.uns.btb.core.appointment;

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
import rs.ftn.uns.btb.core.appointment.dtos.AppointmentDTO;
import rs.ftn.uns.btb.core.appointment.interfaces.AppointmentService;
import rs.ftn.uns.btb.core.center.Center;
import rs.ftn.uns.btb.core.staff.Staff;
import rs.ftn.uns.btb.core.staff.interfaces.StaffService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/appointment")
public class AppointmentController {

    public final AppointmentService _appointmentService;
    public final StaffService _staffService;

    @Autowired
    public AppointmentController(AppointmentService _appointmentService, StaffService _staffService) {
        this._appointmentService = _appointmentService;
        this._staffService = _staffService;
    }

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

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Appointment>> getAll(){
        return new ResponseEntity<List<Appointment>>(_appointmentService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/createAppointment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        Appointment savedAppointment = null;
        System.out.println("Enter");
        Staff staff = _staffService.findOne(appointmentDTO.getStaff_id());
        System.out.println("Staff");
        Center center = staff.getCenter();
        System.out.println("Center");

        if (staff == null || center == null) {
            return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
        }

        System.out.println("A ok");

        try {
            Appointment newAppointment = new Appointment();
            newAppointment.copyValuesFromAppointmentDto(appointmentDTO);
            newAppointment.setStaff(staff);
            newAppointment.setCenter(center);
            savedAppointment = _appointmentService.create(newAppointment);
            return new ResponseEntity<Appointment>(savedAppointment, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Appointment>(savedAppointment, HttpStatus.CONFLICT);
        }
    }

    /*@PostMapping(value = "/addAppointment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment = null;
        try {
            savedAppointment = _appointmentService.create(appointment);
            return new ResponseEntity<Appointment>(savedAppointment, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Appointment>(savedAppointment, HttpStatus.CONFLICT);
        }
    }*/


    @Operation(summary = "Delete multiple appointments", description = "Delete multiple appointments", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "appointments successfully deleted",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "404", description = "one of the appointments not found", content = @Content)
    })
    @DeleteMapping(value = "delete/multiple", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteMultipleAppointments(@RequestBody Long[] idsOfAppointmentsToRemove) {
//        System.out.println("IDS:");
//
//        for (Long l : idsOfAppointmentsToRemove) {
//            System.out.println(l);
//        }

        if (idsOfAppointmentsToRemove.length == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        _appointmentService.deleteSelection(idsOfAppointmentsToRemove);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
