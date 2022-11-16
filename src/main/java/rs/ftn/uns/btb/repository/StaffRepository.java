package rs.ftn.uns.btb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.model.Person;
import rs.ftn.uns.btb.model.Staff;

import java.util.Collection;
import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    public Staff findOneById(Long id);

    public List<Staff> findAllByCenter_Id(Long center_id);

}
