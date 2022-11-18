package rs.ftn.uns.btb.core.staff.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StaffCreateDTO {

    private Long jmbg;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String country;
    private String gender;
    private Long center_id;

    public StaffCreateDTO() {}

//    public StaffCreateDTO(Staff staff) {
//        this.jmbg = staff.getJmbg();
//        this.firstName = staff.getFirstName();
//        this.lastName = staff.getLastName();
//        this.email = staff.getEmail();
//        this.password = staff.getPassword();
//        this.phone = staff.getPhone();
//        this.address = staff.getAddress();
//        this.city = staff.getCountry();
//        this.gender = staff.getGender();
//    }

}
