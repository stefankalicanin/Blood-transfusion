package rs.ftn.uns.btb.service;
import rs.ftn.uns.btb.model.Center;
import rs.ftn.uns.btb.model.SurveyQuestions;

import java.util.Collection;

public interface SurveyQuestionsService {

    Collection<SurveyQuestions> findAll();
}
