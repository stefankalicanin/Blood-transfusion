package rs.ftn.uns.btb.core.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ftn.uns.btb.core.admin.dtos.ChangeAdminPasswordDTO;
import rs.ftn.uns.btb.core.admin.interfaces.AdminService;
import rs.ftn.uns.btb.core.user.Roles;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class AdminServiceImpl implements AdminService {

    public final AdminRepository _adminRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AdminServiceImpl(AdminRepository _adminRepo) { this._adminRepo = _adminRepo; }
    @Override
    public Admin create(Admin admin) throws Exception {
        admin.setRole(Roles.ADMIN);
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        Admin newAdmin = this._adminRepo.save(admin);
        return newAdmin;
    }
    @Override
    public Admin updateByPassword(ChangeAdminPasswordDTO dto) throws  Exception
    {

         Admin newAdmin=this._adminRepo.findOneById(dto.getId());
        if (newAdmin == null) {
            throw new Exception("Admin does not exist");
        }
        newAdmin.setPassword(passwordEncoder.encode(dto.getPassword()));
        newAdmin.setStatus(true);

        Admin updatedAdminByPassword =this._adminRepo.save(newAdmin);
        return updatedAdminByPassword;
    }

    @Override
    public Admin findByEmail(String email) {
        return this._adminRepo.findOneByEmail(email);
    }
}
