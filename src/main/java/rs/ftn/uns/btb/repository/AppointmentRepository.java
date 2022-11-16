package rs.ftn.uns.btb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.model.Appointment;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByCenterId(Long id);
}
