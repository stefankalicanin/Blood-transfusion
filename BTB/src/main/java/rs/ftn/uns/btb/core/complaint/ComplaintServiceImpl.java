package rs.ftn.uns.btb.core.complaint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.core.complaint.interfaces.ComplaintService;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    public final ComplaintRepository _complaintRepo;

    @Autowired
    public ComplaintServiceImpl(ComplaintRepository _complaintRepo) {
        this._complaintRepo = _complaintRepo;
    }

    @Override
    public List<Complaint> findAllWithoutAnswer(Long id) {
        List<Complaint> complaints = _complaintRepo.findByAnswerIsNullAndAdmin_idEquals(id);

        return complaints;
    }

    @Override
    public List<Complaint> findAllWithAnswer(Long id) {
        List<Complaint> complaints = _complaintRepo.findByAnswerIsNotNullAndAdmin_idEquals(id);
        
        return complaints;
    }

    @Override
    public List<Complaint> findAllComplaintByUser(Long id) {
        List<Complaint> complaints = _complaintRepo.findByAnswerIsNotNullAndUser_idEquals(id);
        
        return complaints;
    }

    @Override
    public Complaint findOneById(Long id) {
        Complaint complaint = _complaintRepo.findOneById(id);

        return complaint;
    }

    @Override
    public Complaint update(Complaint complaint) {
        Complaint updatedComplaint = _complaintRepo.save(complaint);

        return updatedComplaint;
    }

    
}
