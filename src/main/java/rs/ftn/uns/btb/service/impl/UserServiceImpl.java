package rs.ftn.uns.btb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.model.User;
import rs.ftn.uns.btb.repository.UserRepository;
import rs.ftn.uns.btb.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    public final UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public User create(User user) throws Exception {
        User newUser = this.userRepo.save(user);
        return newUser;
    }
}
