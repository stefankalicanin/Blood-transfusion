package rs.ftn.uns.btb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("user")
public class User extends Person{

    @Column(name = "profession", nullable = true)
    @Getter @Setter
    private String profession;

    @Column(name = "job", nullable = true)
    @Getter @Setter
    private String job;

    @Column(name = "penalty", nullable = true)
    @Getter @Setter
    private Integer penalty;

    public User() {}

}
