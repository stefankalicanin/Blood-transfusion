package rs.ftn.uns.btb.core.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.core.admin.Admin;
import rs.ftn.uns.btb.core.staff.Staff;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    public Admin findOneByEmailAndPassword(String email, String password);
    public Admin findOneById(Long id);
}
