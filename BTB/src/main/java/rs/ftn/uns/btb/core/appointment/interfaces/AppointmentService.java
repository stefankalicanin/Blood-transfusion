package rs.ftn.uns.btb.core.appointment.interfaces;
import rs.ftn.uns.btb.core.appointment.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> findByCenterId(Long id);

    void deleteSelection(Long[] idsOfAppointmentsToRemove);

    Appointment findOne(Long id);
}
