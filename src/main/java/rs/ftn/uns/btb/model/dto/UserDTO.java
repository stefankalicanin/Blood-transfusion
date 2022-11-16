package rs.ftn.uns.btb.model.dto;

import lombok.Getter;
import lombok.Setter;

public class UserDTO {
    @Getter
    @Setter
    private Long jmbg;
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private String email;

    public UserDTO() {}

    public UserDTO(Long jmbg, String firstName, String lastName, String email) {
        this.jmbg = jmbg;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
