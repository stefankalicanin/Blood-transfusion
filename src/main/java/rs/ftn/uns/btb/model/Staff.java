package rs.ftn.uns.btb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("staff")
public class Staff extends Person {

    @ManyToOne(fetch = FetchType.EAGER)
    @Getter @Setter
    private Center center;

    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter
    private Set<Appointment> scheduledAppointments = new HashSet<>();

    public Staff() {}
}
