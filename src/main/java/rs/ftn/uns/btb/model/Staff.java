package rs.ftn.uns.btb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import rs.ftn.uns.btb.model.dto.StaffDTO;
import rs.ftn.uns.btb.repository.CenterRepository;

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

    public void copyValuesFromDTO(StaffDTO staffDTO) {
        this.setJmbg((staffDTO.getJmbg()));
        this.setFirstName(staffDTO.getFirstName());
        this.setLastName(staffDTO.getLastName());
        this.setPassword(staffDTO.getPassword());
        this.setEmail(staffDTO.getEmail());
    }

    @Override
    public String toString() {
        String rez = "";
        rez +=
                this.getFirstName() + " " + this.getLastName() + " " +
                this.getPassword() + " " + this.getEmail();

        return rez;
    }
}
