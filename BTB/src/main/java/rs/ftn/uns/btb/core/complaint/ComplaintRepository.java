package rs.ftn.uns.btb.core.complaint;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long>{

   
    public List<Complaint> findByAnswerIsNullAndAdmin_idEquals(Long id);

    public List<Complaint> findByAnswerIsNotNullAndAdmin_idEquals(Long id);

    public List<Complaint> findByAnswerIsNotNullAndUser_idEquals(Long id);

    public Complaint findOneById(Long id);
    
    
}
