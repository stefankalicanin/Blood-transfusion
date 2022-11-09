package rs.ftn.uns.btb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ftn.uns.btb.model.User;
import rs.ftn.uns.btb.repository.UserRepository;
import rs.ftn.uns.btb.service.UserService;

import java.util.ArrayList;
import java.util.Collection;

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
    public User findOne(Long id) {
        /*
        Collection<User> users = this._userRepo.findAll();
        for (User user : users){
            if (user.getId() == id) {return user;}
        }
        return null;*/
        User user = this._userRepo.findOneById(id);
        return  user;
    }
    @Override
    public User checkLogin(String email,String password){
        //User user = this._userRepo.checkLogin(email,password);
        User user = this._userRepo.findOneByEmailAndPassword(email,password);
        return user;
    }
}
