package rs.ftn.uns.btb.core.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.core.role.Role;
import rs.ftn.uns.btb.core.role.RoleRepository;
import rs.ftn.uns.btb.core.role.interfaces.IRole;
import rs.ftn.uns.btb.core.staff.interfaces.StaffService;
import rs.ftn.uns.btb.core.user.Roles;

import java.util.Arrays;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    public final StaffRepository _staffRepo;

    @Autowired
    private IRole _roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public StaffServiceImpl(StaffRepository _staffRepo) {
        this._staffRepo = _staffRepo;
    }

    @Autowired
    private RoleRepository _repo;

    @Override
    public Staff create(Staff staff) throws Exception {
        // staff.setRole(Roles.STAFF);
        staff.setPassword(passwordEncoder.encode(staff.getPassword()));

        // List<Role> roles = _roleService.findByName("ROLE_USER");

        String[] strRoles = {"ROLE_USER", "ROLE_STAFF" };

        List<Role> roles = _repo.findAllByName(Arrays.asList(strRoles));

        staff.setRoles(roles);

        Staff newStaff = this._staffRepo.save(staff);
        return newStaff;
    }

    @Override
    public Staff findOne(Long id) {
        return this._staffRepo.findById(id).orElseGet(null);
    }

    @Override
    public Staff update(Staff staff) throws Exception {
        Staff staffToUpdate = this._staffRepo.findOneById(staff.getId());

        if (staffToUpdate == null) {
            throw new Exception("Staff does not exist");
        }

        staffToUpdate.setJmbg(staff.getJmbg());
        staffToUpdate.setFirstName(staff.getFirstName());
        staffToUpdate.setLastName(staff.getLastName());
        staffToUpdate.setPassword(staff.getPassword());
        staffToUpdate.setEmail(staff.getEmail());

        Staff updatedStaff = _staffRepo.save(staffToUpdate);

        return updatedStaff;
    }

    @Override
    public List<Staff> findAllByCenterId(Long id) {
        return _staffRepo.findAllByCenter_Id(id);
    }

    @Override
    public List<Role> getRolesByStaff(Long id) {
        Staff staff = this.findOne(id);

        if (staff == null) {
            return null;
        }

        List<Role> allRoles = this._staffRepo.findAllRolesByStaffId(staff.getId());

        return allRoles;
    }
}
