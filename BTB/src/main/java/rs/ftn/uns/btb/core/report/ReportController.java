package rs.ftn.uns.btb.core.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import rs.ftn.uns.btb.core.appointment.Appointment;
import rs.ftn.uns.btb.core.appointment.interfaces.AppointmentService;
import rs.ftn.uns.btb.core.appointment.interfaces.AppointmentState;
import rs.ftn.uns.btb.core.report.dtos.ReportCreateDTO;
import rs.ftn.uns.btb.core.report.interfaces.ReportService;
import rs.ftn.uns.btb.core.user.User;
import rs.ftn.uns.btb.core.user.interfaces.UserService;

@RestController
@RequestMapping(value = "/api/report")
public class ReportController {

    public final ReportService _reportService;
    public final UserService _userService;
    public final AppointmentService _appointmentService;

    @Autowired
    public ReportController(ReportService _reportService, UserService _userService, AppointmentService _appointmentService) { 
        this._reportService = _reportService; 
        this._userService = _userService;
        this._appointmentService = _appointmentService;
    }


    @Operation(summary = "Create new report", description = "Create new report", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Created",
                content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Report.class))}),
        @ApiResponse(responseCode = "400", description = "Not possible to create new report when user/appointment id are not known",
                content = @Content),
        @ApiResponse(responseCode = "409", description = "Not possible to create new report when there's already report for given appointment id",
                content = @Content),
        @ApiResponse(responseCode = "404", description = "Not possible to create new report when user or appointment with given ID cannot be found",
                content = @Content)
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('STAFF')")
    public ResponseEntity<Report> createReport(@RequestBody ReportCreateDTO reportDTO) {

        if (reportDTO.getAppointment_id() == null || reportDTO.getUser_id() == null) {
            return new ResponseEntity<Report>(HttpStatus.BAD_REQUEST);
        }

        User user = _userService.findOne(reportDTO.getUser_id());
        Appointment appointment = _appointmentService.findOne(reportDTO.getAppointment_id());

        if (user == null || appointment == null) {
            return new ResponseEntity<Report>(HttpStatus.NOT_FOUND);
        }

        Report savedReport = null;

        try {
            Report newReport = new Report();
            newReport.copyValuesFromCreateDTO(reportDTO);
            newReport.setAppointment(appointment);
            newReport.setUser(user);
            savedReport = _reportService.create(newReport);
            return new ResponseEntity<Report>(savedReport, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Report>(savedReport, HttpStatus.CONFLICT);
        }

    }

    
}
