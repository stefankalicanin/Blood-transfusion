package rs.ftn.uns.btb.core.scheduled_appointment;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduledAppointmentRepository extends JpaRepository<ScheduledAppointment, Long> {

    Set<ScheduledAppointment> findAllByUsersId(Long id);
    
}
