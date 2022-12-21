package rs.ftn.uns.btb.core.scheduled_appointment.dtos;

import java.sql.Date;
import java.sql.Time;

import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.scheduled_appointment.ScheduledAppointment;

@Getter @Setter
public class ScheduledAppointmentsViewDTO {

    // scheduled appointments ID
    private Long id;

    // appointments info
    private Long appointment_id;
    private Date date;
    private Time time;
    private Integer duration;

    // staff info
    private String staffFirstName;
    private String staffLastName;
    
    // center info
    private String centerName;


    public ScheduledAppointmentsViewDTO() {}

    public void copyValues(ScheduledAppointment sApp) {
        this.id = sApp.getId();
        
        this.appointment_id = sApp.getAppointment().getId();
        this.date = sApp.getAppointment().getDate();
        this.time = sApp.getAppointment().getTime();
        this.duration = sApp.getAppointment().getDuration();

        this.staffFirstName = sApp.getAppointment().getStaff().getFirstName();
        this.staffLastName = sApp.getAppointment().getStaff().getLastName();

        this.centerName = sApp.getAppointment().getCenter().getName();
    }

    
    
}
