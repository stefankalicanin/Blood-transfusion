package rs.ftn.uns.btb.core.appointment.interfaces;
import rs.ftn.uns.btb.core.appointment.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment create(Appointment appointment) throws  Exception;

    List<Appointment> findByCenterId(Long id);

    List<Appointment> findAll();
    List<Appointment> getAllAvailable();
    void deleteSelection(Long[] idsOfAppointmentsToRemove);

    Appointment findOne(Long id);

    Appointment update(Appointment appointment) throws Exception;
    //Iterable<Appointment> GetAll() throws Exception;

}
