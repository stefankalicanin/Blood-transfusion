package rs.ftn.uns.btb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("user")
@Getter @Setter
public class User extends Person{

    @Column(name = "profession", nullable = true)
    private String profession;

    @Column(name = "job", nullable = true)
    private String job;

    @Column(name = "penalty", nullable = true)
    private Integer penalty;

    public User() {}

}
