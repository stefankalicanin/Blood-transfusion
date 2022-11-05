package rs.ftn.uns.btb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.model.Blood;

// Konsultovati se s ostalima kad dodjes do toga da
// trebas nesto implementirati ovde
public interface BloodRepository extends JpaRepository<Blood, String> {
}
