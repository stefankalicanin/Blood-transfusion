package rs.ftn.uns.btb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.model.dto.UserUpdateDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("user")
@Getter @Setter
public class User extends Person{

    @Column(name = "profession", nullable = true)
    private String profession;

    @Column(name = "job", nullable = true)
    private String job;

    @Column(name = "penalty", nullable = true)
    private Integer penalty;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter
    @JsonIgnore
    private Set<SurveyAnswers> surveyAnswers = new HashSet<>();
    public User() {}

    public User(UserUpdateDTO userUpdateDTO) {
        this.setJmbg((userUpdateDTO.getJmbg()));
        this.setFirstName(userUpdateDTO.getFirstName());
        this.setLastName(userUpdateDTO.getLastName());
        this.setEmail(userUpdateDTO.getEmail());
        this.setGender(userUpdateDTO.getGender());
        this.setPhone(userUpdateDTO.getPhone());
        this.setAddress(userUpdateDTO.getAddress());
        this.setCity(userUpdateDTO.getCity());
        this.setCountry(userUpdateDTO.getCountry());
        this.setProfession(userUpdateDTO.getProfession());
        this.setJob(userUpdateDTO.getJob());
    }

}
