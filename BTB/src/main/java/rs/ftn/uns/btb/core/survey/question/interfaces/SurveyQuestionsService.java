package rs.ftn.uns.btb.core.survey.question.interfaces;
import rs.ftn.uns.btb.core.survey.question.SurveyQuestions;

import java.util.Collection;

public interface SurveyQuestionsService {

    Collection<SurveyQuestions> findAll();
}
