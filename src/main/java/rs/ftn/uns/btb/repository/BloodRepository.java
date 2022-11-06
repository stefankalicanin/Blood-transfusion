package rs.ftn.uns.btb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.model.Blood;

public interface BloodRepository extends JpaRepository<Blood, String> {
}
