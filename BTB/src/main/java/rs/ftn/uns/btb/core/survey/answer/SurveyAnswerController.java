package rs.ftn.uns.btb.core.survey.answer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.ftn.uns.btb.core.survey.answer.dtos.SurveyAnswersDTO;
import rs.ftn.uns.btb.core.survey.answer.dtos.UserAnswersDTO;
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
    @PreAuthorize("hasRole('USER')")
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

    @Operation(summary = "Answers for user", description = "Find all survey answers for specific user", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found answers by user id",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UserAnswersDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Answers not found", content = @Content)
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<UserAnswersDTO>> getUserAnswers(@Parameter(name = "id", description = "ID of a user to look survey answers for", required = true) @PathVariable("id") Long id) {

        List<UserAnswersDTO> userAnswers = new ArrayList<>();
        List<SurveyAnswers> answers = this.survey_service.findAllByUsersId(id);

        if (answers == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        for (SurveyAnswers answer : answers) {
            UserAnswersDTO answ = new UserAnswersDTO();
            answ.setQuestion(answer.getSurvey_questions().getQuestion());
            answ.setAnswer(answer.getAnswer());
            userAnswers.add(answ);
        }

        return new ResponseEntity<List<UserAnswersDTO>>(userAnswers, HttpStatus.OK);
    }
}
