package rs.ftn.uns.btb.core.survey.question;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.core.survey.question.SurveyQuestions;

public interface SurveyQuestionsRepository extends JpaRepository<SurveyQuestions, Long> {
    public SurveyQuestions findOneById(Long id);
}
