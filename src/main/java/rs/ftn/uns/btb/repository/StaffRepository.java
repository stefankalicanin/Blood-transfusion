package rs.ftn.uns.btb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.model.Person;
import rs.ftn.uns.btb.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    public Staff findOneById(Long id);
}
