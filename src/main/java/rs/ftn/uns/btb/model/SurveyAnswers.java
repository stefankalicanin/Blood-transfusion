package rs.ftn.uns.btb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

}
