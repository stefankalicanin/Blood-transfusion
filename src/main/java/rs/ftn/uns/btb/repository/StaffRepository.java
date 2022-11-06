package rs.ftn.uns.btb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.model.Person;

public interface StaffRepository extends JpaRepository<Person, Long> {
}
