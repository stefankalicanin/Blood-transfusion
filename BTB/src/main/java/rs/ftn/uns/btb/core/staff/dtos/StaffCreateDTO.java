package rs.ftn.uns.btb.core.staff.dtos;

import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.user.Roles;

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
    private Roles role;

    public StaffCreateDTO() {}

}
