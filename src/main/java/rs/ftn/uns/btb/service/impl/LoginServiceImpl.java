package rs.ftn.uns.btb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ftn.uns.btb.model.Admin;
import rs.ftn.uns.btb.model.Staff;
import rs.ftn.uns.btb.model.User;
import rs.ftn.uns.btb.model.dto.LoginDTO;
import rs.ftn.uns.btb.repository.AdminRepository;
import rs.ftn.uns.btb.repository.StaffRepository;
import rs.ftn.uns.btb.repository.UserRepository;
import rs.ftn.uns.btb.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
    public final UserRepository _userRepo;
    public final AdminRepository _adminRepo;
    public final StaffRepository _staffRepo;

    @Autowired
    public LoginServiceImpl(UserRepository _userRepo, AdminRepository _adminRepo, StaffRepository _staffRepo) {
        this._userRepo = _userRepo;
        this._adminRepo = _adminRepo;
        this._staffRepo = _staffRepo;
    }
    @Override
    public LoginDTO checkLogin(String email, String password){
        //User user = this._userRepo.checkLogin(email,password);
        User user = this._userRepo.findOneByEmailAndPassword(email,password);
        LoginDTO loginDTO = new LoginDTO();
        if (user != null) {
            loginDTO.setId(user.getId());
            loginDTO.setEmail(user.getEmail());
            loginDTO.setRole("user");
            loginDTO.setCenter_id(null);
            return loginDTO;
        }
        Admin admin = this._adminRepo.findOneByEmailAndPassword(email,password);
        if( admin != null){
            loginDTO.setId(admin.getId());
            loginDTO.setEmail(admin.getEmail());
            loginDTO.setRole("admin");
            loginDTO.setCenter_id(null);
            return loginDTO;
        }
        Staff staff = this._staffRepo.findOneByEmailAndPassword(email,password);
        if( staff != null){
            loginDTO.setId(staff.getId());
            loginDTO.setEmail(staff.getEmail());
            loginDTO.setRole("staff");
            staff.getCenter().getId();
            loginDTO.setCenter_id(staff.getCenter().getId());
            return loginDTO;
        }
        return loginDTO;
    }
}
