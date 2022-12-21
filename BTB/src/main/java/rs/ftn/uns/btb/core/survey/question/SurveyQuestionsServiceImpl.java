package rs.ftn.uns.btb.core.survey.question;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import org.springframework.stereotype.Service;
import rs.ftn.uns.btb.core.survey.question.interfaces.SurveyQuestionsService;

@Service
public class SurveyQuestionsServiceImpl implements SurveyQuestionsService {
    public final SurveyQuestionsRepository survey_questions_repo;

    @Autowired
    public SurveyQuestionsServiceImpl(SurveyQuestionsRepository survey_questions_repo) { this.survey_questions_repo = survey_questions_repo; }

    @Override
    public Collection<SurveyQuestions> findAll() {
        Collection<SurveyQuestions> survey_questions = survey_questions_repo.findAll();
        return survey_questions;
    }
}
