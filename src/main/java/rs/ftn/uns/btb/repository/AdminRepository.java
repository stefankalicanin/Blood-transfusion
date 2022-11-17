package rs.ftn.uns.btb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.model.Admin;
import rs.ftn.uns.btb.model.User;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    public Admin findOneByEmailAndPassword(String email, String password);
}
