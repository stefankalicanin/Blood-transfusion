package rs.ftn.uns.btb.core.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.core.appointment.interfaces.AppointmentService;
import rs.ftn.uns.btb.core.appointment.interfaces.AppointmentState;

import java.util.Arrays;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    public final AppointmentRepository _appointmentRepo;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository _appointmentRepo) { this._appointmentRepo = _appointmentRepo; }

    @Override
    public Appointment create(Appointment appointment) throws  Exception{
        appointment.setState(AppointmentState.AVAILABLE);
        Appointment newAppointment = this._appointmentRepo.save(appointment);
        return newAppointment;
    }

    @Override
    public List<Appointment> findByCenterId(Long id) {
        List<Appointment> appointmentsForCenter = _appointmentRepo.findAllByCenterId(id);
        return appointmentsForCenter;
    }

    @Override
    public void deleteSelection(Long[] idsOfAppointmentsToRemove) {
        _appointmentRepo.deleteAllById(Arrays.asList(idsOfAppointmentsToRemove));
    }

    @Override
    public Appointment findOne(Long id) {
        return this._appointmentRepo.findById(id).orElseGet(null);
    }
    
    public List<Appointment> findAll() {
        List<Appointment> allAppointments = _appointmentRepo.findAll();
        return allAppointments;
    }

    @Override
    public Appointment update(Appointment appointment) throws Exception {
        Appointment appointmentToUpdate = this._appointmentRepo.findOneById(appointment.getId());

        if (appointmentToUpdate == null) {
            throw new Exception("Appointment does not exist");
        }

        appointmentToUpdate.setDate(appointment.getDate());
        appointmentToUpdate.setTime(appointment.getTime());
        appointmentToUpdate.setDuration(appointment.getDuration());
        appointmentToUpdate.setState(appointment.getState());

        Appointment updatedAppointment = _appointmentRepo.save(appointmentToUpdate);

        return updatedAppointment;
    }
    /*
    @Override
    public Iterable<Appointment> GetAll() throws Exception {
        return _appointmentRepo.findAll();
    }*/

}
