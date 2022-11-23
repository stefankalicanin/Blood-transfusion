package rs.ftn.uns.btb.core.login.dtos;

import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.user.Roles;

@Getter @Setter
public class LoginDTO {
        private Long id;
        private String email;
        private Roles role;

        private Long center_id;

        public LoginDTO() {}

        public LoginDTO(String email, String password, Roles role) {
            this.email = email;
            this.role = role;
        }

}
