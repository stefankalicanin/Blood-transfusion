package rs.ftn.uns.btb.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class StaffUpdateDTO {

    private Long id;
    private Long jmbg;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String country;
    private String center_id;

    public StaffUpdateDTO() {}

//    public StaffUpdateDTO(Long jmbg, String firstName, String lastName, String password, String email) {
//        this.jmbg = jmbg;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//    }

}
