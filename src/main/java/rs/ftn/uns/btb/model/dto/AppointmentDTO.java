package rs.ftn.uns.btb.model.dto;

import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.model.Appointment;

import java.sql.Date;
import java.sql.Time;

@Getter @Setter
public class AppointmentDTO {

    private Long id;
    private Date date;
    private Time time;
    private Integer duration;

    private Long staff_id;
    private String staffFirstName;
    private String staffLastName;

    public AppointmentDTO() {}

    public void copyValues(Appointment appointment) {
        // Appointment
        this.id = appointment.getId();
        this.date = appointment.getDate();
        this.time = appointment.getTime();
        this.duration = appointment.getDuration();
        // Staff
        this.staff_id = appointment.getStaff().getId();
        this.staffFirstName = appointment.getStaff().getFirstName();
        this.staffLastName = appointment.getStaff().getLastName();
    }
}
