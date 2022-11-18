package rs.ftn.uns.btb.core.survey.question;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.survey.answer.SurveyAnswers;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="survey_questions")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SurveyQuestions {
    @Id
    @Column(name = "id", unique = true)
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Pitanje -> Odgovor
    @Column(name = "question", nullable = false)
    @Getter @Setter
    private String question;


    @OneToMany(mappedBy = "survey_questions", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter
    @JsonIgnore
    private Set<SurveyAnswers> surveyAnswers = new HashSet<>();

    public SurveyQuestions() {}
}
