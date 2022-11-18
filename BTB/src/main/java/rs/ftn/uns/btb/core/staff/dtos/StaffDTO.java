package rs.ftn.uns.btb.core.staff.dtos;

import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.staff.Staff;

@Getter @Setter
public class StaffDTO {

    private Long id;
    private Long jmbg;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String country;
    private Long center_id;

    public StaffDTO() {}

    public StaffDTO(Staff staff) {
        this.id = staff.getId();
        this.jmbg = staff.getJmbg();
        this.firstName = staff.getFirstName();
        this.lastName = staff.getLastName();
        this.email = staff.getEmail();
        this.address = staff.getAddress();
        this.phone = staff.getPhone();
        this.city = staff.getCity();
        this.country = staff.getCountry();
        this.center_id = staff.getCenter().getId();
    }
}
