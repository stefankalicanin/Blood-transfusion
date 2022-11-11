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
import rs.ftn.uns.btb.model.Admin;
import rs.ftn.uns.btb.model.SurveyAnswers;
import rs.ftn.uns.btb.service.AdminService;
import rs.ftn.uns.btb.service.SurveyAnswerService;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/answers")
public class SurveyAnswerController {
    public final SurveyAnswerService _adminService;

    @Autowired
    public SurveyAnswerController(SurveyAnswerService _adminService) { this._adminService = _adminService; }

    @Operation(summary = "Add new answers", description = "Add new answers", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Added",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Admin.class)) }),
            @ApiResponse(responseCode = "409", description = "Not possible to add new answer, bad request",
                    content = @Content)
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SurveyAnswers> createAnswers(@RequestBody ArrayList<SurveyAnswers> answers) {
        //ArrayList<SurveyAnswers> savedAnswer = new ArrayList<SurveyAnswers>();;
        SurveyAnswers sa = null;
        try {
            sa = _adminService.create(answers);
            return new ResponseEntity<SurveyAnswers>(sa, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<SurveyAnswers>(sa, HttpStatus.CONFLICT);
        }
    }
}
