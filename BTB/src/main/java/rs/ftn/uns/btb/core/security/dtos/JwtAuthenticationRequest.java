package rs.ftn.uns.btb.core.security.dtos;

import lombok.Getter;
import lombok.Setter;

// Login
@Getter @Setter
public class JwtAuthenticationRequest {
    
    private String email;
    private String password;

    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }
}
