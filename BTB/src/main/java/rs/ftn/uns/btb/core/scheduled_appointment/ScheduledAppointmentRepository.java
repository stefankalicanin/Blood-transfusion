package rs.ftn.uns.btb.core.scheduled_appointment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduledAppointmentRepository extends JpaRepository<ScheduledAppointment, Long> {
    
}
