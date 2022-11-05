package rs.ftn.uns.btb.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
public class User {
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

    // Authorized to use BTB services
    @Column(name = "status", nullable = false)
    @Getter @Setter
    private Boolean status;

    // TODO:
    // Enum Type?
    @Column(name = "gender", nullable = false)
    @Getter @Setter
    private String gender;

    // TODO:
    // Role: String Type -> Enum Type
    // Enum - new class
    @Column(name = "role", nullable = false)
    @Getter @Setter
    private  String role;

    public User() {}

}

// TODO:
// nullable: firstname, lastname, gender, etc.?