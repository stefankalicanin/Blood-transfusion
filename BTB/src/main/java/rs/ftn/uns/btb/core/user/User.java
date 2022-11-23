package rs.ftn.uns.btb.core.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.appointment.Appointment;
import rs.ftn.uns.btb.core.scheduled_appointment.ScheduledAppointment;
import rs.ftn.uns.btb.core.survey.answer.SurveyAnswers;
import rs.ftn.uns.btb.core.user.dtos.UserUpdateDTO;
import rs.ftn.uns.btb.core.user.interfaces.Person;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter @Setter
public class User extends Person {

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

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    private Set<ScheduledAppointment> scheduledAppointments = new HashSet<>();    

    // @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    // @JoinTable(
    //     name = "scheduledApp",
    //     joinColumns = @JoinColumn(
    //         name = "user_id",
    //         referencedColumnName = "id"
    //     ),
    //     inverseJoinColumns = @JoinColumn(
    //         name = "appointment_id",
    //         referencedColumnName = "id"
    //     )
    // )
    // @JsonIgnore
    // private Set<Appointment> allAppointments = new HashSet<>();

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
