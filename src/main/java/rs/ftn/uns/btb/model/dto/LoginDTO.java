package rs.ftn.uns.btb.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginDTO {
        private Long id;
        private String email;
        private String role;

        private Long center_id;

        public LoginDTO() {}

        public LoginDTO(String email, String password, String role) {
            this.email = email;
            this.role = role;
        }

}
