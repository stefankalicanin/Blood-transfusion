package rs.ftn.uns.btb.core.staff.interfaces;
import rs.ftn.uns.btb.core.role.Role;
import rs.ftn.uns.btb.core.staff.Staff;

import java.util.List;

public interface StaffService {

    Staff create(Staff staff) throws Exception;

    Staff findOne(Long id);

    Staff update(Staff staff) throws Exception;

    List<Staff> findAllByCenterId(Long id);

    List<Role> getRolesByStaff(Long id);

    Staff findByEmail(String email);
}
