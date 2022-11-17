package rs.ftn.uns.btb.model.dto;

import lombok.Getter;
import lombok.Setter;

public class LoginDTO {
        @Getter
        @Setter
        private String email;
        @Getter @Setter
        private String password;

        @Getter @Setter
        private String roll;
        @Getter @Setter
        private Long centar_id;

        public LoginDTO() {}

        public LoginDTO(String email, String password, String roll) {
            this.email = email;
            this.password = password;
            this.roll = roll;
        }

}
