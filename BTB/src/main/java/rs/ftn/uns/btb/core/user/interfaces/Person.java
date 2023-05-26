package rs.ftn.uns.btb.core.user.interfaces;


import java.util.List;

import javax.persistence.*;



import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.role.Role;
import rs.ftn.uns.btb.core.user.Roles;

@MappedSuperclass
@Getter @Setter
public abstract class Person {
    // TODO:
    // Mozda napraviti ipak vise entiteta, svaki da predstavlja svoju rolu
    // zbog nekih suvisnih atributa

    // TODO:
    // Long -> String || Integer

//    @Id
//    @Column(name = "id", unique = true)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Id
    @Column(name = "id", unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_id_seq")
    @SequenceGenerator(name = "entity_id_seq", sequenceName = "global_id_sequence", allocationSize = 1)
    protected Long id;

    @Column(name = "role", nullable = false, length = 20)
    private Roles role;

    @Column(name = "jmbg", unique = true, nullable = false, length = 13)
    private Long jmbg;

    @Column(name = "firstName", nullable = false, length = 25)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 45)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false, length = 90)
    private String email;
    
    @Column(name = "password", nullable = false)
    private String password;

    // Authorized to use BTB services, email confirmation
    @Column(name = "status", nullable = false)
    private Boolean status;

    // loggedInBefore

    @Column(name = "gender", nullable = true, length = 20)
    private String gender;

    @Column(name="phone", nullable = true, length = 50) // unique
    private String phone;

    @Column(name="address", nullable = true, length = 120)
    private String address;

    @Column(name = "city", nullable = true, length = 80)
    private String city;

    @Column(name = "country", nullable = true, length = 60)
    private String country;
   
    public Person() {}

    @ManyToMany
    // @JoinTable(name = "roles")
    private List<Role> roles;

    /*

    // required for security 

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @Override
    public boolean isEnabled() {
        return status;
    }

    public String getUsername() {
        return email;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return this.status;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    */
    
}

// TODO:
// nullable: firstname, lastname, gender, etc.?