package rs.ftn.uns.btb.model.dto;

import lombok.Getter;
import lombok.Setter;

public class UserUpdateDTO {

    @Getter @Setter
    private Long jmbg;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String gender;

    @Getter @Setter
    private String phone;

    @Getter @Setter
    private String address;

    @Getter @Setter
    private String city;

    @Getter @Setter
    private String country;

    public UserUpdateDTO(){}

    public UserUpdateDTO(Long jmbg, String firstName, String lastName, String password, String email, String gender, String phone, String address, String city, String country){
        this.jmbg = jmbg;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.country = country;
    }
}
