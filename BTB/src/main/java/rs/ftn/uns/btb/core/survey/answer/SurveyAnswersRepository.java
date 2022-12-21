package rs.ftn.uns.btb.core.survey.answer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.core.survey.answer.SurveyAnswers;

public interface SurveyAnswersRepository extends JpaRepository<SurveyAnswers, Long> {
    //SurveyAnswers create(SurveyAnswers surveyAnswers) throws Exception;

    List<SurveyAnswers> findAllByUsersId(Long id);
}
