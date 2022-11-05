package rs.ftn.uns.btb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.model.Person;

// Konsultovati se s ostalima kad dodjes do toga da
// trebas nesto implementirati ovde

public interface StaffRepository extends JpaRepository<Person, Long> {
}
