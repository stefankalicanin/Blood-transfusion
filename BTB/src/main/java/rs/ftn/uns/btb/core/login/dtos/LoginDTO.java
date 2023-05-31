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

        private boolean isSuperAdmin;

        private boolean status;

        public LoginDTO() {}

        public LoginDTO(String email, String password, Roles role, boolean isSuperAdmin, boolean status) {
            this.email = email;
            this.role = role;
            this.isSuperAdmin = isSuperAdmin;
            this.status = status;

        }

}
