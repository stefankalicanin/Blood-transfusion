package rs.ftn.uns.btb.core.admin;

import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.user.interfaces.Person;
import rs.ftn.uns.btb.core.complaint.Complaint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "admins")
@Getter @Setter
public class Admin extends Person {

    @Column(name = "super_admin", nullable = false)
    private Boolean isSuperAdmin=false;

    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter
    @JsonIgnore
    private Set<Complaint> complaints = new HashSet<>();

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
