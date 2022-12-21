package rs.ftn.uns.btb.core.survey.answer.interfaces;

import java.util.List;

import rs.ftn.uns.btb.core.survey.answer.SurveyAnswers;
import rs.ftn.uns.btb.core.survey.answer.dtos.SurveyAnswersDTO;

public interface SurveyAnswerService {
    SurveyAnswersDTO create(SurveyAnswersDTO surveyAnswersDTO) throws Exception;

    List<SurveyAnswers> findAllByUsersId(Long id);
}
