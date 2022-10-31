package java.ftn.uns.btb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date; // SQL DATE = YYYY-MM-DD, JAVAUTIL DATE = YYYY-MM-DD HH:MM:SS
import java.sql.Time;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Column(nullable = false, unique = true)
    @Getter @Setter
    private Long id;

    @Column(name = "DATE", nullable = false)
    @Getter @Setter
    private Date date;

    @Column(name = "TIME", nullable = false)
    @Getter @Setter
    private Time time;

    @Column(name = "DURATION", nullable = false)
    @Getter @Setter
    private Integer duration;

    // Centar u kom postoji termin
    @ManyToOne(fetch = FetchType.EAGER)
    @Getter @Setter
    private Center center;

    public Appointment() {}

}