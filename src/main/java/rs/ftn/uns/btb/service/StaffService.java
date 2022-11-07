package rs.ftn.uns.btb.service;
import rs.ftn.uns.btb.model.Staff;

public interface StaffService {

    Staff create(Staff staff) throws Exception;

    Staff findOne(Long jmbg);

    Staff update(Staff staff) throws Exception;
}
