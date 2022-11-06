package rs.ftn.uns.btb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
