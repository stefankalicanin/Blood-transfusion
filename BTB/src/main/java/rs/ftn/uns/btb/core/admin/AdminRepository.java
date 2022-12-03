package rs.ftn.uns.btb.core.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ftn.uns.btb.core.admin.Admin;
import rs.ftn.uns.btb.core.role.Role;
import rs.ftn.uns.btb.core.staff.Staff;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    public Admin findOneByEmailAndPassword(String email, String password);
    public Admin findOneById(Long id);

    public Admin findOneByEmail(String email);

    // @Query(value = "SELECT r.name FROM ADMINS_ROLES ar, role r WHERE ar.roles_id = r.id AND ar.admin_id = ?1")
    // public List<Role> getAllRoles(Long id);
}
