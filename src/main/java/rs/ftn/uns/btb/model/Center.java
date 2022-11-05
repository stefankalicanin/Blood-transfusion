package rs.ftn.uns.btb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "center")
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    @Getter @Setter
    private Long id;

    @Column(name = "NAME", nullable = false)
    @Getter @Setter
    private String name;

    @Column(name = "ADDRESS", nullable = false)
    @Getter @Setter
    private String address;

    @Column(name = "DESCRIPTION", nullable = true)
    @Getter @Setter
    private String description; // opis neki, gledao po specifikaciji
    // mozda malo nesretno ime, description -> info?

    @Column(name = "GRADE", nullable = true, precision = 2)
    @Getter @Setter
    private Double grade;   // prosecna ocena centra

    // 1 centar moze imati N termina
    @OneToMany(mappedBy = "center", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter
    private Set<Appointment> availableAppointments = new HashSet<>();

    @OneToMany(mappedBy = "center", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter
    private Set<Blood> amountOfBlood = new HashSet<>();

    @OneToMany(mappedBy = "center", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter
    private Set<Staff> staff = new HashSet<>();

    public Center() {}
}
