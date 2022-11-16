package rs.ftn.uns.btb.service;
import  rs.ftn.uns.btb.model.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> findByCenterId(Long id);

    void deleteSelection(Long[] idsOfAppointmentsToRemove);
}
