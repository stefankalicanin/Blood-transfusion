package rs.ftn.uns.btb.core.staff;

import org.springframework.data.jpa.repository.JpaRepository;
// import rs.ftn.uns.btb.core.staff.Staff;
import org.springframework.data.jpa.repository.Query;

import rs.ftn.uns.btb.core.role.Role;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    public Staff findOneById(Long id);

    public List<Staff> findAllByCenter_Id(Long center_id);
    public Staff findOneByEmailAndPassword(String email, String password);

    public Staff findOneByEmail(String email);

    @Query(value = "SELECT r.name FROM staffs_roles sr, role r WHERE sr.roles_id = r.id AND sr.staff_id = ?1", nativeQuery = true)
    public List<Role> findAllRolesByStaffId(Long id);

}
