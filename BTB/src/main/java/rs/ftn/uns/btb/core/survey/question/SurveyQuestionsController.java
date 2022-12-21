package rs.ftn.uns.btb.core.survey.question;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ftn.uns.btb.core.survey.question.interfaces.SurveyQuestionsService;

import java.util.Collection;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/questions")
public class SurveyQuestionsController {
    public final SurveyQuestionsService survey_questions_service;
    @Autowired
    public SurveyQuestionsController(SurveyQuestionsService survey_questions_service) { this.survey_questions_service = survey_questions_service; }

    @Operation(summary = "Get all questions", description = "Get all questions", method="GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = SurveyQuestions.class))))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Collection<SurveyQuestions>> getUsers() {
        Collection<SurveyQuestions> survey_questions = survey_questions_service.findAll();
        return new ResponseEntity<Collection<SurveyQuestions>>(survey_questions, HttpStatus.OK);
    }
}
