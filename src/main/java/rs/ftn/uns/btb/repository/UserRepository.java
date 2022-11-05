package rs.ftn.uns.btb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.model.User;

// Konsultovati se s ostalima kad dodjes do toga da
// trebas nesto implementirati ovde

public interface UserRepository extends JpaRepository<User, Long> {
}
