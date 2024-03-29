package rs.ftn.uns.btb.core.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ftn.uns.btb.core.login.dtos.LoginDTO;
import rs.ftn.uns.btb.core.admin.Admin;
import rs.ftn.uns.btb.core.login.interfaces.LoginService;
import rs.ftn.uns.btb.core.staff.Staff;
import rs.ftn.uns.btb.core.user.User;
import rs.ftn.uns.btb.core.admin.AdminRepository;
import rs.ftn.uns.btb.core.staff.StaffRepository;
import rs.ftn.uns.btb.core.user.UserRepository;

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
        User user = this._userRepo.findOneByEmail(email);
        LoginDTO loginDTO = new LoginDTO();
        if (user != null) {
            loginDTO.setId(user.getId());
            loginDTO.setEmail(user.getEmail());
            loginDTO.setRole(user.getRole());
            loginDTO.setCenter_id(null);
            return loginDTO;
        }
        Admin admin = this._adminRepo.findOneByEmail(email);
        if( admin != null){
            loginDTO.setId(admin.getId());
            loginDTO.setEmail(admin.getEmail());
            loginDTO.setRole(admin.getRole());
            loginDTO.setCenter_id(null);
            loginDTO.setSuperAdmin(admin.getIsSuperAdmin());
            loginDTO.setStatus(admin.getStatus());
            return loginDTO;
        }
        Staff staff = this._staffRepo.findOneByEmail(email);
        if( staff != null){
            loginDTO.setId(staff.getId());
            loginDTO.setEmail(staff.getEmail());
            loginDTO.setRole(staff.getRole());
            loginDTO.setCenter_id(staff.getCenter().getId());
            return loginDTO;
        }
        return loginDTO;
    }
}
