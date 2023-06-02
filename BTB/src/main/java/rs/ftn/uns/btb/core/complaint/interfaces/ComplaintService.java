package rs.ftn.uns.btb.core.complaint.interfaces;
import rs.ftn.uns.btb.core.complaint.Complaint;

import java.util.List;

public interface ComplaintService {

    List<Complaint> findAllWithoutAnswer(Long id);
    
    List<Complaint> findAllWithAnswer(Long id);

    List<Complaint> findAllComplaintByUser(Long id);
    
    Complaint findOneById(Long id);

    Complaint update(Complaint complaint);
    
}
