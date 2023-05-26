package rs.ftn.uns.btb.core.center;

import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.appointment.Appointment;
import rs.ftn.uns.btb.core.blood.Blood;
import rs.ftn.uns.btb.core.center.dtos.CenterUpdateDTO;
import rs.ftn.uns.btb.core.center.dtos.SearchCenterDTO;
import rs.ftn.uns.btb.core.staff.Staff;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "center")
@Getter @Setter
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, columnDefinition = "VARCHAR(30)") //
    private String name;

    @Column(name = "ADDRESS", nullable = false, columnDefinition = "VARCHAR(95)")
    private String address;

    @Column(name = "DESCRIPTION", nullable = true)
    private String description; // opis neki, gledao po specifikaciji
    // mozda malo nesretno ime, description -> info?

    @Column(name = "GRADE", nullable = true, precision = 2)
    private Double grade;   // prosecna ocena centra

    // 1 centar moze imati N termina
    @OneToMany(mappedBy = "center", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Appointment> availableAppointments = new HashSet<>();

    @OneToMany(mappedBy = "center", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Blood> amountOfBlood = new HashSet<>();

    @OneToMany(mappedBy = "center", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Staff> staff = new HashSet<>();

    public Center() {}

    public void copyValues(Center center) {
        this.name = center.getName();
        this.address = center.getAddress();
        this.description = center.getDescription();
        this.grade = center.getGrade();
    }

    public void copyValuesFromDTO(CenterUpdateDTO centerUpdateDTO) {
        this.name = centerUpdateDTO.getName();
        this.address = centerUpdateDTO.getAddress();
        this.description = centerUpdateDTO.getDescription();
        this.grade = centerUpdateDTO.getGrade();
    }

    public void copyValuesFromDTO(SearchCenterDTO searchCenterDTO){
        this.name = searchCenterDTO.getName();
        this.address = searchCenterDTO.getAddress();
        this.grade = searchCenterDTO.getGrade();
    }


}
