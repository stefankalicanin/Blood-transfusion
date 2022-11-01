package rs.ftn.uns.btb.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
public class User {
    // TODO:
    // Mozda napraviti ipak vise entiteta, svaki da predstavlja svoju rolu
    // zbog nekih suvisnih atributa

    // TODO:
    // Long -> String || Integer
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JMBG", unique = true, nullable = false)
    @Getter @Setter
    private Long jmbg;

    @Column(name = "FIRSTNAME", nullable = false)
    @Getter @Setter
    private String firstName;

    @Column(name = "LASTNAME", nullable = false)
    @Getter @Setter
    private String lastName;

    @Column(name = "EMAIL", nullable = false)
    @Getter @Setter
    private String email;
    
    @Column(name = "PASSWORD", nullable = false)
    @Getter @Setter
    private String password;

    // Authorized to use BTB services
    @Column(name = "STATUS", nullable = false)
    @Getter @Setter
    private Boolean status;

    // TODO:
    // Enum Type?
    @Column(name = "GENDER", nullable = false)
    @Getter @Setter
    private String gender;

    // TODO:
    // Role: String Type -> Enum Type
    // Enum - new class
    @Column(name = "ROLE", nullable = false)
    @Getter @Setter
    private  String role;

    public User() {}

}

// TODO:
// nullable: firstname, lastname, gender, etc.?