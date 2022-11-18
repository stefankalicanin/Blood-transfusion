package rs.ftn.uns.btb.core.user.interfaces;

import rs.ftn.uns.btb.core.user.User;

import java.util.List;

public interface UserService {

    User create(User user) throws Exception;
    List<User> findAll();
    User findById(Long id);
    User findOne(Long id);
    User checkLogin(String email, String password);
    List<User> findByFirstNameAndLastName(String firstName, String lastName);
    User update(User user) throws Exception;
}

