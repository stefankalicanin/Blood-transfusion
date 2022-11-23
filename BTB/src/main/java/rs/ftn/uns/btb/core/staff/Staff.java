package rs.ftn.uns.btb.core.staff;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import rs.ftn.uns.btb.core.appointment.Appointment;
import rs.ftn.uns.btb.core.center.Center;
import rs.ftn.uns.btb.core.staff.dtos.StaffCreateDTO;
import rs.ftn.uns.btb.core.staff.dtos.StaffUpdateDTO;
import rs.ftn.uns.btb.core.user.interfaces.Person;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "staffs")
@Getter @Setter
public class Staff extends Person {

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @Getter @Setter
    private Center center;

    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Appointment> scheduledAppointments = new HashSet<>();

    public Staff() {}

    public void copyValuesFromUpdateDTO(StaffUpdateDTO staffDTO) {
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

    public void copyValuesFromCreateDTO(StaffCreateDTO staffDTO) {
        this.setJmbg((staffDTO.getJmbg()));
        this.setFirstName(staffDTO.getFirstName());
        this.setLastName(staffDTO.getLastName());
        this.setPassword(staffDTO.getPassword());
        this.setEmail(staffDTO.getEmail());
        this.setAddress(staffDTO.getAddress());
        this.setCity(staffDTO.getCity());
        this.setCountry(staffDTO.getCountry());
        this.setPhone(staffDTO.getPhone());
        this.setGender(staffDTO.getGender());
        this.setRole(staffDTO.getRole());
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
