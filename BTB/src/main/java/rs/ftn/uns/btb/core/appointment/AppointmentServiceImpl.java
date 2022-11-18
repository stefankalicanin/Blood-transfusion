package rs.ftn.uns.btb.core.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.core.appointment.interfaces.AppointmentService;

import java.util.Arrays;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    public final AppointmentRepository _appointmentRepo;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository _appointmentRepo) { this._appointmentRepo = _appointmentRepo; }

    @Override
    public List<Appointment> findByCenterId(Long id) {
        List<Appointment> appointmentsForCenter = _appointmentRepo.findAllByCenterId(id);
        return appointmentsForCenter;
    }

    @Override
    public void deleteSelection(Long[] idsOfAppointmentsToRemove) {
        _appointmentRepo.deleteAllById(Arrays.asList(idsOfAppointmentsToRemove));
    }

}
