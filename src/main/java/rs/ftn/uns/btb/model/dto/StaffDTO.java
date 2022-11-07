package rs.ftn.uns.btb.model.dto;

import lombok.Getter;
import lombok.Setter;

public class StaffDTO {

    @Getter @Setter
    private Long jmbg;
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private String email;

    public StaffDTO() {}

    public StaffDTO(Long jmbg, String firstName, String lastName, String password, String email) {
        this.jmbg = jmbg;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

}
