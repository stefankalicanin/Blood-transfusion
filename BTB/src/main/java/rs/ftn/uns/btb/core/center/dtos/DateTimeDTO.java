package rs.ftn.uns.btb.core.center.dtos;

import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.appointment.Appointment;
import rs.ftn.uns.btb.core.center.Center;

import java.sql.Date;
import java.sql.Time;

public class DateTimeDTO {
    @Getter @Setter
    private Date date;
    @Getter @Setter
    private Time time;



    public DateTimeDTO(Date date, Time time){
        this.date = date;
        this.time = time;
    }

}
