package rs.ftn.uns.btb.service;
import rs.ftn.uns.btb.model.User;
import rs.ftn.uns.btb.model.dto.UserDTO;

import java.util.Collection;
import java.util.List;

public interface UserService {

    User create(User user) throws Exception;

    Collection<User> findAll();
    List<User> findByFirstNameAndLastName(String firstName, String lastName);

    User update(User user) throws Exception;

    User findOne(Long jmbg);
}

