package rs.ftn.uns.btb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ftn.uns.btb.model.Staff;
import rs.ftn.uns.btb.repository.AdminRepository;
import rs.ftn.uns.btb.service.AdminService;
import rs.ftn.uns.btb.model.Admin;

@Service
public class AdminServiceImpl implements AdminService {

    public final AdminRepository _adminRepo;

    @Autowired
    public AdminServiceImpl(AdminRepository _adminRepo) { this._adminRepo = _adminRepo; }
    @Override
    public Admin create(Admin admin) throws Exception {
        Admin newAdmin = this._adminRepo.save(admin);
        return newAdmin;
    }
}
