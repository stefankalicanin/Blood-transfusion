package rs.ftn.uns.btb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.model.Staff;
import rs.ftn.uns.btb.repository.StaffRepository;
import rs.ftn.uns.btb.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {

    public final StaffRepository _staffRepo;

    @Autowired
    public StaffServiceImpl(StaffRepository _staffRepo) {
        this._staffRepo = _staffRepo;
    }
    @Override
    public Staff create(Staff staff) throws Exception {
        Staff newStaff = this._staffRepo.save(staff);
        return newStaff;
    }

    @Override
    public Staff findOne(Long jmbg) {
        return this._staffRepo.findById(jmbg).orElseGet(null);
    }

    @Override
    public Staff update(Staff staff) throws Exception {
        Staff staffToUpdate = this._staffRepo.findOneById(staff.getId());

        if (staffToUpdate == null) {
            throw new Exception("Staff does not exist");
        }

        staffToUpdate.setJmbg(staff.getJmbg());
        staffToUpdate.setFirstName(staff.getFirstName());
        staffToUpdate.setLastName(staff.getLastName());
        staffToUpdate.setPassword(staff.getPassword());
        staffToUpdate.setEmail(staff.getEmail());

        Staff updatedStaff = _staffRepo.save(staffToUpdate);

        return updatedStaff;
    }
}
