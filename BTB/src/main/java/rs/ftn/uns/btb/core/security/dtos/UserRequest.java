package rs.ftn.uns.btb.core.security.dtos;

import lombok.Getter;
import lombok.Setter;

// Register
@Getter @Setter
public class UserRequest {
    
    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private Long jmbg;
    
}
