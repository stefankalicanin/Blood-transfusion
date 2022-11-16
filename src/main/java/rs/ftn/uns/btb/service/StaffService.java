package rs.ftn.uns.btb.service;
import rs.ftn.uns.btb.model.Staff;

import java.util.List;

public interface StaffService {

    Staff create(Staff staff) throws Exception;

    Staff findOne(Long id);

    Staff update(Staff staff) throws Exception;

    List<Staff> findAllByCenterId(Long id);
}
