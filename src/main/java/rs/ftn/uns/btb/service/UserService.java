package rs.ftn.uns.btb.service;
import rs.ftn.uns.btb.model.User;

import java.util.List;

public interface UserService {

    User create(User user) throws Exception;

    User update(User user) throws Exception;

    User findOne(Long jmbg);

    List<User> findAll();

    User findById(Long id);
}
