package rs.ftn.uns.btb.core.survey.answer;

import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.survey.question.SurveyQuestions;
import rs.ftn.uns.btb.core.user.User;

import javax.persistence.*;

@Entity
@Table(name="survey_answers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SurveyAnswers {

    @Id
    @Column(name = "id", unique = true)
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "survey_questions_id")
    @Getter @Setter
    private SurveyQuestions survey_questions;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id")
    @Getter @Setter
    private User users;

    @Column(name = "answer", nullable = false)
    @Getter @Setter
    private Boolean answer;

    public SurveyAnswers() {}
    public SurveyAnswers(SurveyQuestions survey_questions,User users,Boolean answer) {
        this.survey_questions = survey_questions;
        this.users = users;
        this.answer = answer;
    }

}
