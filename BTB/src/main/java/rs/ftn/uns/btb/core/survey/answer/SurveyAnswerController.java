package rs.ftn.uns.btb.core.survey.answer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ftn.uns.btb.core.survey.answer.dtos.SurveyAnswersDTO;
import rs.ftn.uns.btb.core.survey.answer.interfaces.SurveyAnswerService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/answers")
public class SurveyAnswerController {
    public final SurveyAnswerService survey_service;

    @Autowired
    public SurveyAnswerController(SurveyAnswerService survey_service) { this.survey_service = survey_service; }


    @Operation(summary = "Add new answers", description = "Add new answers", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Added",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = SurveyAnswersDTO.class)) }),
            @ApiResponse(responseCode = "409", description = "Not possible to add new answer, bad request",
                    content = @Content)
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SurveyAnswersDTO> createAnswers(@RequestBody SurveyAnswersDTO answersDTO) {
        SurveyAnswersDTO sa = null;
        try {
            sa = survey_service.create(answersDTO);
            return new ResponseEntity<SurveyAnswersDTO>(sa, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<SurveyAnswersDTO>(sa, HttpStatus.CONFLICT);
        }
    }
}
