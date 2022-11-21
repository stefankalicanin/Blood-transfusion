package rs.ftn.uns.btb.core.report;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.ftn.uns.btb.core.appointment.Appointment;
import rs.ftn.uns.btb.core.blood.interfaces.BloodType;
import rs.ftn.uns.btb.core.report.interfaces.Attendance;
import rs.ftn.uns.btb.core.user.User;

@Entity
@Table(name="report")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {

    @Id
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    /* Info:
            StaffID
            CenterID
            Date
    */
    // @ManyToOne(fetch = FetchType.EAGER)
    // private Appointment appointment;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment_id", referencedColumnName = "id")
    private Appointment appointment;

    @Column(name = "status", nullable = false)
    private Attendance attendanceStatus;

    // Move blood_type inside User class or allow nullable?
    @Column(name = "blood_type", nullable = false)
    private BloodType bloodType;

    @Column(name = "blood_quantity", nullable = false)
    private String bloodQuantity;

    @Column(name = "doctor_note", nullable = true)
    private String note; 
}
