package rs.ftn.uns.btb.core.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rs.ftn.uns.btb.core.appointment.Appointment;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByCenterId(Long id);
    List<Appointment> findAll();

    Appointment findOneById(Long id);
//SELECT * FROM appointment app where app.center_id = ?1 and app.date = ?2 and ((?3 between app.time and app.time + interval '1 hour' * app.duration) OR (?3 + interval '1 hour' * ?4 between app.time and app.time + interval '1 hour' * app.duration))
    // @Query(value = "SELECT * FROM appointment app WHERE app.center_id = ?1 AND app.date = ?2 AND ((?3 BETWEEN app.time AND app.time + interval '1 hour' * app.duration) OR (?4 between app.time AND app.time + interval '1 hour' * app.duration) OR (?3 < app.time AND ?4 > app.time + interval '1 hour' * app.duration))", nativeQuery = true)
    @Query(value = "SELECT * FROM appointment app " +
                   "WHERE app.center_id = ?1 AND app.date = ?2 AND " +
                   "app.staff_id = ?5 AND " +
                   "app.state != 2 AND " +
                   "((?3 BETWEEN app.time AND app.time + interval '1 hour' * app.duration) OR (?4 between app.time AND app.time + interval '1 hour' * app.duration) " +
                   "OR (?3 < app.time AND ?4 > app.time + interval '1 hour' * app.duration))", nativeQuery = true)
    List<Appointment> findAllOverlappings(Long centerId, Date date, Time startTime, Time endTime, Long staffId);

    // where app.center_id = ?1 and app.date = ?2 and (?3 between app.time and app.time + interval '1 hour' * app.duration)
    //OR (?3 + interval '1 hour' * ?4 between app.time and app.time + interval '1 hour' * app.duration)
    //app.id, app.date, app.duration, app.state, app.time, app.center_id, app.staff_id

}

// @Query(value = "SELECT * FROM appointment app" +
//                    "WHERE app.center_id = ?1 AND app.date = ?2 AND" +
//                    "((?3 BETWEEN app.time AND app.time + interval '1 hour' * app.duration) OR (?4 between app.time AND app.time + interval '1 hour' * app.duration)" +
//                    "OR (?3 < app.time AND ?4 > app.time + interval '1 hour' * app.duration))", nativeQuery = true)
