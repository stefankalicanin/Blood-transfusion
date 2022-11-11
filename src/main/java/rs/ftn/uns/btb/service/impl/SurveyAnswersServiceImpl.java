package rs.ftn.uns.btb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ftn.uns.btb.model.Staff;
import rs.ftn.uns.btb.model.SurveyAnswers;
import rs.ftn.uns.btb.model.SurveyQuestions;
import rs.ftn.uns.btb.repository.SurveyAnswersRepository;
import rs.ftn.uns.btb.repository.SurveyQuestionsRepository;
import rs.ftn.uns.btb.service.SurveyAnswerService;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class SurveyAnswersServiceImpl implements SurveyAnswerService {
    public final SurveyAnswersRepository survey_answers_repo;

    @Autowired
    public SurveyAnswersServiceImpl(SurveyAnswersRepository survey_answers_repo) { this.survey_answers_repo = survey_answers_repo; }

    @Override
    public SurveyAnswers create(ArrayList<SurveyAnswers> survey_answers) throws Exception {
        SurveyAnswers new_an = null;
        for (SurveyAnswers survey_answer : survey_answers) {
            if(survey_answer.getAnswer() != null) {
                new_an = this.survey_answers_repo.save(survey_answer);
            }
        }
        return new_an;
    }
}
