package rs.ftn.uns.btb.core.admin;

import rs.ftn.uns.btb.core.user.interfaces.Person;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends Person {

    public Admin() {}
}
