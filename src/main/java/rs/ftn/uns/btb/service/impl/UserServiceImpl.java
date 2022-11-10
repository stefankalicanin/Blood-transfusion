package rs.ftn.uns.btb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ftn.uns.btb.model.User;
import rs.ftn.uns.btb.repository.UserRepository;
import rs.ftn.uns.btb.service.UserService;

import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public final UserRepository _userRepo;

    @Autowired
    public UserServiceImpl(UserRepository _userRepo) { this._userRepo = _userRepo; }

    @Override
    public User create(User user) throws Exception {
        User newUser = this._userRepo.save(user);
        return newUser;
    }
    @Override
    public Collection<User> findAll() {
        Collection<User> users = _userRepo.findAll();
        return users;
    }
    @Override
    public List<User> findByFirstNameAndLastName(String firstName, String lastName) {
        return _userRepo.findByFirstNameAndLastNameAllIgnoringCase(firstName, lastName);
    }
}
