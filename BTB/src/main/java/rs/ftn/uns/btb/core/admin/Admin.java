package rs.ftn.uns.btb.core.admin;

import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.user.interfaces.Person;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
@Getter @Setter
public class Admin extends Person {

    @Column(name = "super_admin", nullable = false)
    private Boolean isSuperAdmin;

    public Admin() {}


    public Admin(Boolean isSuperAdmin) {
        super();
        this.isSuperAdmin = isSuperAdmin;
    }

}
