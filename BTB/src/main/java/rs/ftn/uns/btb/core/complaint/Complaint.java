package rs.ftn.uns.btb.core.complaint;

import rs.ftn.uns.btb.core.complaint.interfaces.ComplaintType;
import rs.ftn.uns.btb.core.user.User;
import rs.ftn.uns.btb.core.admin.Admin;
import rs.ftn.uns.btb.core.complaint.dto.ComplaintDTO;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "complaint")
@Getter @Setter
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "CONTEXT", nullable = false, columnDefinition = "VARCHAR(30)") 
    private String context;

    @Column(name = "ANSWER", nullable = true, columnDefinition = "VARCHAR(30)") 
    private String answer;

    @Column(name = "TYPE", nullable = false) 
    private ComplaintType type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public Complaint() {}
    
    public Complaint (String context, String answer, ComplaintType type, User user, Admin admin) {
        this.context = context;
        this.answer = answer;
        this.type = type;
        this.user = user;
        this.admin = admin;
    }

  

    
}
