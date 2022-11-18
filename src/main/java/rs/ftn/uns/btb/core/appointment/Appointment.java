package rs.ftn.uns.btb.core.appointment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.center.Center;
import rs.ftn.uns.btb.core.staff.Staff;

import javax.persistence.*;
import java.sql.Date; // SQL DATE = YYYY-MM-DD, JAVAUTIL DATE = YYYY-MM-DD HH:MM:SS
import java.sql.Time;

@Entity
@Table(name = "appointment")
@Getter @Setter
public class Appointment {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATE", nullable = false)
    private Date date;

    @Column(name = "TIME", nullable = false)
    private Time time;

    @Column(name = "DURATION", nullable = false)
    private Integer duration;

    // Centar u kom postoji termin
    @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name="center_id", nullable = false)
    @JsonIgnore
    private Center center;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Staff staff;

    public Appointment() {}

}
