package rs.ftn.uns.btb.service;
import rs.ftn.uns.btb.model.User;

import java.util.ArrayList;
import java.util.Collection;

public interface UserService {

    User create(User user) throws Exception;

    User findOne(Long id);
    User checkLogin(String email, String password);
}
