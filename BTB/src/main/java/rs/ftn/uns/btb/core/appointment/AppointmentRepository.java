package rs.ftn.uns.btb.core.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.core.appointment.Appointment;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByCenterId(Long id);
    List<Appointment> findAll();
}
