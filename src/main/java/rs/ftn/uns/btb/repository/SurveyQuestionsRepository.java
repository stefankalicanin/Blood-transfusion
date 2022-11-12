package rs.ftn.uns.btb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.model.SurveyAnswers;
import rs.ftn.uns.btb.model.SurveyQuestions;

public interface SurveyQuestionsRepository extends JpaRepository<SurveyQuestions, Long> {
    public SurveyQuestions findOneById(Long id);
}
