package rs.ftn.uns.btb.core.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ftn.uns.btb.core.appointment.interfaces.AppointmentService;
import rs.ftn.uns.btb.core.appointment.interfaces.AppointmentState;
import rs.ftn.uns.btb.core.scheduled_appointment.ScheduledAppointmentRepository;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    public final AppointmentRepository _appointmentRepo;
    public final ScheduledAppointmentRepository scheduledAppointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository _appointmentRepo, ScheduledAppointmentRepository scheduledAppointmentRepository) {
        this._appointmentRepo = _appointmentRepo;
        this.scheduledAppointmentRepository = scheduledAppointmentRepository;
    }

    @Override
    @Transactional
    public Appointment create(Appointment appointment) throws  Exception{
        if (overlappingTime(appointment)) {
            throw new Exception("Preklapajuce vreme termina!");
        }
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
    public List<Appointment> getAllAvailable() {


        List<Appointment> allAppointments = _appointmentRepo.findAll();
        Iterator<Appointment> iterator = allAppointments.iterator();
        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();
            if (appointment.getState() != AppointmentState.AVAILABLE) {
                iterator.remove();
            }
        }
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

    private boolean overlappingTime(Appointment appointment) {
        Date date = appointment.getDate();
        Time startTime = appointment.getTime();
        Time endTime = Time.valueOf(startTime.toLocalTime().plusHours(appointment.getDuration()));
        Long centerId = appointment.getCenter().getId();
        Long staffId = appointment.getStaff().getId();
        

        List<Appointment> allOverlapps = this._appointmentRepo.findAllOverlappings(centerId, date, startTime, endTime, staffId);

        if (allOverlapps.size() > 0) {
            return true;
        }

        return false;
    }

}
