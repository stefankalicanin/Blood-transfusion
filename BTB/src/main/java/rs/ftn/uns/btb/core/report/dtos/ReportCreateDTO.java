package rs.ftn.uns.btb.core.report.dtos;

import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.blood.interfaces.BloodType;
import rs.ftn.uns.btb.core.report.interfaces.Attendance;

@Getter @Setter
public class ReportCreateDTO {

    private Long user_id;
    private Long appointment_id;
    private Attendance attendanceStatus;
    private BloodType bloodType;
    private Double bloodQuantity;
    private String doctorsNote;
    private Integer equipmentQuantity;

    public ReportCreateDTO() {}
    
}
