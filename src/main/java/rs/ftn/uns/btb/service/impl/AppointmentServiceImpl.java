package rs.ftn.uns.btb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.repository.AppointmentRepository;
import rs.ftn.uns.btb.service.AppointmentService;
import rs.ftn.uns.btb.model.Appointment;

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
}
