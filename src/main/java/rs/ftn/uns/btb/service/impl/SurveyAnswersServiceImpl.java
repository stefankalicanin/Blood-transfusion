package rs.ftn.uns.btb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ftn.uns.btb.model.SurveyAnswers;
import rs.ftn.uns.btb.model.SurveyQuestions;
import rs.ftn.uns.btb.model.User;
import rs.ftn.uns.btb.model.dto.SurveyAnswersDTO;
import rs.ftn.uns.btb.repository.SurveyAnswersRepository;
import rs.ftn.uns.btb.repository.SurveyQuestionsRepository;
import rs.ftn.uns.btb.repository.UserRepository;
import rs.ftn.uns.btb.service.SurveyAnswerService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Service
public class SurveyAnswersServiceImpl implements SurveyAnswerService {
    public final SurveyAnswersRepository survey_answers_repo;
    public final UserRepository _userRepo;
    public final SurveyQuestionsRepository _questionRepo;
    @Autowired
    public SurveyAnswersServiceImpl(UserRepository _userRepo, SurveyAnswersRepository survey_answers_repo, SurveyQuestionsRepository _questionRepo) {
        this._userRepo = _userRepo;
        this.survey_answers_repo = survey_answers_repo;
        this._questionRepo = _questionRepo;
    }

    @Override
    public SurveyAnswersDTO create(SurveyAnswersDTO survey_answers_dto) throws Exception {
        User user = _userRepo.findOneById(survey_answers_dto.getUser_id());
        for (Map.Entry<Long,Boolean> mapElement : survey_answers_dto.getAnswers().entrySet()) {
            Long key = mapElement.getKey();
            Boolean value = mapElement.getValue(); // true - false
            SurveyQuestions question = _questionRepo.findOneById(key);
            SurveyAnswers surveyAnswers = new SurveyAnswers(question, user, value);
            survey_answers_repo.create(surveyAnswers);
        }
        return survey_answers_dto;
    }
}
