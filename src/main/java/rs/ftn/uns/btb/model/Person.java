package rs.ftn.uns.btb.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role", discriminatorType=DiscriminatorType.STRING, columnDefinition = "VARCHAR(31) CHECK (role IN ('admin', 'staff', 'user'))")
@Getter @Setter
public abstract class Person {
    // TODO:
    // Mozda napraviti ipak vise entiteta, svaki da predstavlja svoju rolu
    // zbog nekih suvisnih atributa

    // TODO:
    // Long -> String || Integer

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jmbg", unique = true, nullable = false)
    private Long jmbg;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;
    
    @Column(name = "password", nullable = false)
    private String password;

    // Authorized to use BTB services, email confirmation
    @Column(name = "status", nullable = false)
    private Boolean status;

    // loggedInBefore

    @Column(name = "gender", nullable = true)
    private String gender;

    @Column(name="phone", nullable = true) // unique
    private String phone;

    @Column(name="address", nullable = true)
    private String address;

    @Column(name = "city", nullable = true)
    private String city;

    @Column(name = "country", nullable = true)
    private String country;

    public Person() {}
}

// TODO:
// nullable: firstname, lastname, gender, etc.?