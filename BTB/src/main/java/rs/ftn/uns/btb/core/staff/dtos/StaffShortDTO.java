package rs.ftn.uns.btb.core.staff.dtos;

import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.staff.Staff;

@Getter @Setter
public class StaffShortDTO {

    private Long id;
    private Long jmbg;
    private String firstName;
    private String lastName;
    private String email;
    private String address;

    private String phone;

    public StaffShortDTO() {}

    public StaffShortDTO(Staff staff) {
        this.id = staff.getId();
        this.jmbg = staff.getJmbg();
        this.firstName = staff.getFirstName();
        this.lastName = staff.getLastName();
        this.email = staff.getEmail();
        this.address = staff.getAddress();
        this.phone = staff.getPhone();
    }

//    public StaffUpdateDTO() {}
//
//    public StaffUpdateDTO(Long jmbg, String firstName, String lastName, String password, String email) {
//        this.jmbg = jmbg;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.password = password;
//        this.email = email;
//    }

    /*

        public void copyValues(Appointment appointment) {
        // Appointment
        this.id = appointment.getId();
        this.date = appointment.getDate();
        this.time = appointment.getTime();
        this.duration = appointment.getDuration();
        // Staff
        this.staff_id = appointment.getStaff().getId();
        this.staffFirstName = appointment.getStaff().getFirstName();
        this.staffLastName = appointment.getStaff().getLastName();
    }
     */

}
