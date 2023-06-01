package rs.ftn.uns.btb.core.scheduled_appointment.interfaces;

import java.util.Set;

import rs.ftn.uns.btb.core.scheduled_appointment.ScheduledAppointment;

public interface ScheduledAppointmentService {

    Set<ScheduledAppointment> findByUserId(Long id);
    ScheduledAppointment findByAppointmentId(Long id);
        
}
