package rs.ftn.uns.btb.core.survey.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ftn.uns.btb.core.survey.answer.dtos.SurveyAnswersDTO;
import rs.ftn.uns.btb.core.survey.answer.interfaces.SurveyAnswerService;
import rs.ftn.uns.btb.core.survey.question.SurveyQuestions;
import rs.ftn.uns.btb.core.survey.question.SurveyQuestionsRepository;
import rs.ftn.uns.btb.core.user.User;
import rs.ftn.uns.btb.core.user.UserRepository;

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
        Long userId = survey_answers_dto.getUser_id();
        User user = this._userRepo.findOneById(userId);
        for (Map.Entry<Long,Boolean> mapElement : survey_answers_dto.getAnswers().entrySet()) {
            Long key = mapElement.getKey();
            Boolean value = mapElement.getValue(); // true - false
            SurveyQuestions question = _questionRepo.findOneById(key);
            SurveyAnswers surveyAnswers = new SurveyAnswers(question, user, value);
            survey_answers_repo.save(surveyAnswers);
        }
        return survey_answers_dto;
    }
}
