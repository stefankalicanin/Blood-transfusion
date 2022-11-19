package rs.ftn.uns.btb.core.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ftn.uns.btb.core.admin.interfaces.AdminService;
import rs.ftn.uns.btb.core.user.Roles;

@Service
public class AdminServiceImpl implements AdminService {

    public final AdminRepository _adminRepo;

    @Autowired
    public AdminServiceImpl(AdminRepository _adminRepo) { this._adminRepo = _adminRepo; }
    @Override
    public Admin create(Admin admin) throws Exception {
        admin.setRole(Roles.ADMIN);
        Admin newAdmin = this._adminRepo.save(admin);
        return newAdmin;
    }
}
