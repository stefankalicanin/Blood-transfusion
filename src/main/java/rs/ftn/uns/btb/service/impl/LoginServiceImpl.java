package rs.ftn.uns.btb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import rs.ftn.uns.btb.model.Admin;
import rs.ftn.uns.btb.model.Staff;
import rs.ftn.uns.btb.model.User;
import rs.ftn.uns.btb.model.dto.LoginDTO;
import rs.ftn.uns.btb.repository.AdminRepository;
import rs.ftn.uns.btb.repository.StaffRepository;
import rs.ftn.uns.btb.repository.UserRepository;
import rs.ftn.uns.btb.service.LoginService;

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
            loginDTO.setEmail(user.getEmail());
            loginDTO.setPassword(user.getPassword());
            loginDTO.setRoll("user");
            loginDTO.setCentar_id(null);
            return loginDTO;
        }
        Admin admin = this._adminRepo.findOneByEmailAndPassword(email,password);
        if( admin != null){
            loginDTO.setEmail(admin.getEmail());
            loginDTO.setPassword(admin.getPassword());
            loginDTO.setRoll("admin");
            loginDTO.setCentar_id(null);
            return loginDTO;
        }
        Staff staff = this._staffRepo.findOneByEmailAndPassword(email,password);
        if( staff != null){
            loginDTO.setEmail(staff.getEmail());
            loginDTO.setPassword(staff.getPassword());
            loginDTO.setRoll("staff");
            staff.getCenter().getId();
            loginDTO.setCentar_id(staff.getCenter().getId());
            return loginDTO;
        }
        return loginDTO;
    }
}
