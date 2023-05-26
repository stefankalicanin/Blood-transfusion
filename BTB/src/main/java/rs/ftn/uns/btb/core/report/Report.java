package rs.ftn.uns.btb.core.report;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.appointment.Appointment;
import rs.ftn.uns.btb.core.blood.interfaces.BloodType;
import rs.ftn.uns.btb.core.report.dtos.ReportCreateDTO;
import rs.ftn.uns.btb.core.report.interfaces.Attendance;
import rs.ftn.uns.btb.core.user.User;

@Entity
@Table(name="report", uniqueConstraints = @UniqueConstraint(columnNames = { "appointment_id" }))
@Getter @Setter
public class Report implements Serializable {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_id_seq")
    @SequenceGenerator(name = "report_id_seq", sequenceName = "reports_id_sequence", allocationSize = 1)
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
    private Double bloodQuantity;

    @Column(name = "doctor_note", nullable = true)
    private String note;

    @Column(name = "equipment_quantity", nullable = true)
    private Integer equipmentQuantity;

    public Report() {}

    public void copyValuesFromCreateDTO(ReportCreateDTO reportDTO) {
        this.setAttendanceStatus(reportDTO.getAttendanceStatus());
        this.setBloodType(reportDTO.getBloodType());
        this.setBloodQuantity(reportDTO.getBloodQuantity());
        this.setNote(reportDTO.getDoctorsNote());
        this.setEquipmentQuantity(reportDTO.getEquipmentQuantity());
    } 
}
