package rs.ftn.uns.btb.core.appointment.dtos;

import lombok.Getter;
import lombok.Setter;
import rs.ftn.uns.btb.core.appointment.interfaces.AppointmentState;

@Getter @Setter
public class AppointmentStateDTO {

    private AppointmentState state;

    public AppointmentStateDTO() {}
}
