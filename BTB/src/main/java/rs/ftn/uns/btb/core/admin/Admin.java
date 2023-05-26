package rs.ftn.uns.btb.core.admin;

import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.user.interfaces.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


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
