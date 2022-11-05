package rs.ftn.uns.btb.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role", discriminatorType=DiscriminatorType.STRING)
public abstract class Person {
    // TODO:
    // Mozda napraviti ipak vise entiteta, svaki da predstavlja svoju rolu
    // zbog nekih suvisnih atributa

    // TODO:
    // Long -> String || Integer
    @Id
    @Column(name = "jmbg", unique = true, nullable = false)
    @Getter @Setter
    private Long jmbg;

    @Column(name = "firstName", nullable = false)
    @Getter @Setter
    private String firstName;

    @Column(name = "lastName", nullable = false)
    @Getter @Setter
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    @Getter @Setter
    private String email;
    
    @Column(name = "password", nullable = false)
    @Getter @Setter
    private String password;

    // Authorized to use BTB services, email confirmation
    @Column(name = "status", nullable = false)
    @Getter @Setter
    private Boolean status;

    @Column(name = "gender", nullable = false)
    @Getter @Setter
    private String gender;

    @Column(name="phone", unique = true, nullable = false)
    @Getter @Setter
    private String phone;

    @Column(name="address", nullable = false)
    @Getter @Setter
    private String address;

    @Column(name = "city", nullable = false)
    @Getter @Setter
    private String city;

    @Column(name = "country", nullable = false)
    @Getter @Setter
    private String country;

    public Person() {}
}

// TODO:
// nullable: firstname, lastname, gender, etc.?