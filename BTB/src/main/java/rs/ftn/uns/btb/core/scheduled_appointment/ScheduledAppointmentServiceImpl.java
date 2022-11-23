package rs.ftn.uns.btb.core.scheduled_appointment;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.core.scheduled_appointment.interfaces.ScheduledAppointmentService;

@Service
public class ScheduledAppointmentServiceImpl implements ScheduledAppointmentService {

    public final ScheduledAppointmentRepository _sAppointmentRepository;

    @Autowired
    public ScheduledAppointmentServiceImpl (ScheduledAppointmentRepository _sAppointmentRepository) {
        this._sAppointmentRepository = _sAppointmentRepository;
    }

    @Override
    public Set<ScheduledAppointment> findByUserId (Long id) {
        Set<ScheduledAppointment> scheduledAppointments = _sAppointmentRepository.findAllByUsersId(id);
        return scheduledAppointments;
    }
    
}
