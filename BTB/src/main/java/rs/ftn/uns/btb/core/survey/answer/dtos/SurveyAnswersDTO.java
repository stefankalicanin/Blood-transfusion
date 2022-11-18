package rs.ftn.uns.btb.core.survey.answer.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class SurveyAnswersDTO {
    @Getter @Setter
    private Long user_id;
    @Getter @Setter
    private HashMap<Long,Boolean> answers = new HashMap<Long,Boolean>();

    /*public SurveyAnswersDTO(Long user_id, Integer survey_questions_id, HashMap<Long,Boolean>  answers ){
        this.user_id = user_id;
        this.answers = answers;
    }*/
    public SurveyAnswersDTO(){}
}
