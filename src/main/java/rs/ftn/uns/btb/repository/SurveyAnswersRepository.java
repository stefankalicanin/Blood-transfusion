package rs.ftn.uns.btb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.model.SurveyAnswers;
import rs.ftn.uns.btb.model.User;

public interface SurveyAnswersRepository extends JpaRepository<SurveyAnswers, Long> {
    SurveyAnswers create(SurveyAnswers surveyAnswers) throws Exception;
}
