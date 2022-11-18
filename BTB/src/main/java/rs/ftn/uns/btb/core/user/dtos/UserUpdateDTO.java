package rs.ftn.uns.btb.core.user.dtos;

import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.user.User;

public class UserUpdateDTO {

    @Getter @Setter
    private Long id;
    @Getter @Setter
    private Long jmbg;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

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

    @Getter @Setter
    private String job;

    @Getter @Setter
    private String profession;

    public UserUpdateDTO(){}

    public UserUpdateDTO(User user){
        this.jmbg = user.getJmbg();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.gender = user.getGender();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.city = user.getCity();
        this.country = user.getCountry();
        this.job = user.getJob();
        this.profession = user.getProfession();
    }
}
