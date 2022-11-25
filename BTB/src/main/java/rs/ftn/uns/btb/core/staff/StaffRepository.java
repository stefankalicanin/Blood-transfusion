package rs.ftn.uns.btb.core.staff;

import org.springframework.data.jpa.repository.JpaRepository;
// import rs.ftn.uns.btb.core.staff.Staff;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    public Staff findOneById(Long id);

    public List<Staff> findAllByCenter_Id(Long center_id);
    public Staff findOneByEmailAndPassword(String email, String password);

}
