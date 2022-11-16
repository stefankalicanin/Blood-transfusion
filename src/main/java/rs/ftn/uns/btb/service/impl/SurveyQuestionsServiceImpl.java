package rs.ftn.uns.btb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import rs.ftn.uns.btb.model.SurveyQuestions;
import rs.ftn.uns.btb.repository.SurveyQuestionsRepository;
import rs.ftn.uns.btb.service.SurveyQuestionsService;
import java.util.Collection;
import org.springframework.stereotype.Service;

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
