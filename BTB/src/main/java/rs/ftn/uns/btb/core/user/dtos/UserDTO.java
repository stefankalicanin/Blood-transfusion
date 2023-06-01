package rs.ftn.uns.btb.core.user.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDTO {

    private Long id;
    private Long jmbg;
    private String firstName;
    private String lastName;
    private String email;

    public UserDTO() {}

    public UserDTO(Long id, Long jmbg, String firstName, String lastName, String email) {
        this.id = id;
        this.jmbg = jmbg;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UserDTO(Long jmbg, String firstName, String lastName, String email) {
        this.jmbg = jmbg;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UserDTO(Long jmbg, String firstName, String lastName) {
        this.jmbg = jmbg;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
