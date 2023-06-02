package rs.ftn.uns.btb.core.complaint;

import rs.ftn.uns.btb.core.Email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import rs.ftn.uns.btb.core.complaint.dto.ComplaintDTO;
import rs.ftn.uns.btb.core.complaint.interfaces.ComplaintService;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


import java.util.List;
import java.util.ArrayList;

@CrossOrigin(origins = "*")

@Tag(name = "Complaint controller", description = "The Complaint API")
@RestController
@RequestMapping(value = "/api/complaint")
public class ComplaintController {

    public final ComplaintService _complaintService;

    @Autowired
    public ComplaintController(ComplaintService _complaintService) { this._complaintService = _complaintService; }

    @Autowired
    private EmailService emailService;

    @Operation(summary = "Get all complaints without answer", description = "Get all complaints without answers", method="GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Complaint.class))))
    })
    @GetMapping(value="/admin/withoutAnswer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Complaint>> findAllWithoutAnswer(@PathVariable Long id) {
        List<Complaint> complaints = _complaintService.findAllWithoutAnswer(id);
       
        return new ResponseEntity<>(complaints, HttpStatus.OK);
    }

    @Operation(summary = "Get all complaints with answer", description = "Get all complaints with answers", method="GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Complaint.class))))
    })
    @GetMapping(value="/admin/withAnswer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Complaint>> findAllWithAnswer(@PathVariable Long id) {
        List<Complaint> complaints = _complaintService.findAllWithAnswer(id);
        List<Complaint> complaints1 = new ArrayList<>();
        for (Complaint c : complaints)
        {
            complaints1.add(new Complaint(c.getContext(), c.getAnswer(), c.getType(), c.getUser(), c.getAdmin()));
        }
        return new ResponseEntity<>(complaints1, HttpStatus.OK);
    }

    @Operation(summary = "Get all complaints with answer", description = "Get all complaints with answers", method="GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Complaint.class))))
    })
    @GetMapping(value="/user/withAnswer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Complaint>> findAllComplaintByUser(@PathVariable Long id) {
        List<Complaint> complaints = _complaintService.findAllComplaintByUser(id);
        List<Complaint> complaints1 = new ArrayList<>();
        for (Complaint c : complaints)
        {
            complaints1.add(new Complaint(c.getContext(), c.getAnswer(), c.getType(), c.getUser(), c.getAdmin()));
        }
        return new ResponseEntity<>(complaints1, HttpStatus.OK);
    }

    @Operation(summary = "Update an existing complaint", description = "Update an existing complaint with answer from admin", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Center successfully edited",
                    content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = Complaint.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Complaint not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
    @PostMapping(value = "/update/{id}/{answer}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Complaint> update(@PathVariable Long id, @PathVariable String answer) {
        Complaint complaintForUpdate = _complaintService.findOneById(id);
        complaintForUpdate.setAnswer(answer);
        Complaint updatedComplaint = _complaintService.update(complaintForUpdate);
        emailService.sendEmail("skstefankalicanin@gmail.com", "Admin answer for your complaint:"+answer,"Complaint" );
        return new ResponseEntity<Complaint>(updatedComplaint, HttpStatus.OK);

    }
    
}
