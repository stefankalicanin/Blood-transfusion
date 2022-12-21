package rs.ftn.uns.btb.core.admin;

import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.role.Role;
import rs.ftn.uns.btb.core.user.interfaces.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "admins")
@Getter @Setter
public class Admin extends Person {

    @Column(name = "super_admin", nullable = false)
    private Boolean isSuperAdmin=false;

    public Admin() {}


    public Admin(Boolean isSuperAdmin) {
        super();
        this.isSuperAdmin = isSuperAdmin;
    }

    // @JsonIgnore
    // @ManyToMany(fetch = FetchType.LAZY)
    // @JoinTable(name = "admins_roles",
    //         joinColumns = @JoinColumn(name = "admin_id", referencedColumnName = "id"),
    //         inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "id"))
    // private List<Role> roles;

    // @JsonIgnore
    // @Override
    // @Transactional
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     return this.getRoles();
    // }

}
