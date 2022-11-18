package rs.ftn.uns.btb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import rs.ftn.uns.btb.model.dto.StaffUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import rs.ftn.uns.btb.model.dto.StaffDTO;
import rs.ftn.uns.btb.repository.CenterRepository;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("staff")
@Getter @Setter
public class Staff extends Person {

    @ManyToOne(fetch = FetchType.EAGER)
    @Getter @Setter
    private Center center;

    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Appointment> scheduledAppointments = new HashSet<>();

    public Staff() {}

    public void copyValuesFromDTO(StaffUpdateDTO staffDTO) {
        this.setJmbg((staffDTO.getJmbg()));
        this.setFirstName(staffDTO.getFirstName());
        this.setLastName(staffDTO.getLastName());
        this.setPassword(staffDTO.getPassword());
        this.setEmail(staffDTO.getEmail());
        this.setAddress(staffDTO.getAddress());
        this.setCity(staffDTO.getCity());
        this.setCountry(staffDTO.getCountry());
        this.setPhone(staffDTO.getPhone());
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
