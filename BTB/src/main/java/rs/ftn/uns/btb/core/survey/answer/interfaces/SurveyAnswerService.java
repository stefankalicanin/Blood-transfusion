package rs.ftn.uns.btb.core.survey.answer.interfaces;

import rs.ftn.uns.btb.core.survey.answer.dtos.SurveyAnswersDTO;

public interface SurveyAnswerService {
    SurveyAnswersDTO create(SurveyAnswersDTO surveyAnswersDTO) throws Exception;
}
