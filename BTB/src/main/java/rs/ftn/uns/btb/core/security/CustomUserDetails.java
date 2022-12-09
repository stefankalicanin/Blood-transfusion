package rs.ftn.uns.btb.core.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.role.Role;


@Getter @Setter
public class CustomUserDetails implements UserDetails {

    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(String email, String password, String role) {
        this.email = email;
        this.password = password;
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(role));
        // for (Role role : roles) {
        //     grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        // }
        this.authorities = grantedAuthorities;
    }

    public CustomUserDetails(String email, String password, List<Role> roles) {
        this.email = email;
        this.password = password;
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        // grantedAuthorities.add(new SimpleGrantedAuthority(role));
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        this.authorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }    
}
