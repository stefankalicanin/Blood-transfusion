package rs.ftn.uns.btb.core.survey.answer.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserAnswersDTO {
    
    private String question;
    private Boolean answer;

    public UserAnswersDTO() {}

}
