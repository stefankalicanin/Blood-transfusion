package rs.ftn.uns.btb.core.center;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

public interface CenterRepository extends JpaRepository<Center, Long> {

    public Center findOneById(Long id);

    // public Center findByName(String name);

    public List<Center> findAll();

    public List<Center> findByNameContainingIgnoreCase(String name);

    public List<Center> findByAddressContainingIgnoreCase(String address);

    public List<Center> findByNameContainingIgnoreCaseAndAddressContainingIgnoreCase(String name, String address);

    /*@Query(value = "SELECT c.name, c.grade, c.address" +
            "FROM center c, appointment ap" +
            "WHERE ap.date != ?1 and ap.time != ?2", nativeQuery = true)
    List<Center>findAllByDateAndTime(Date date, Time time);

    @Query(value = "SELECT distinct c.id, c.name, c.grade, c.address, c.description " +
            "FROM center c, appointment ap " +
            "WHERE ap.date != ?1", nativeQuery = true)
    List<Center>findAllByDate(Date date);*/

    @Query(value = "SELECT * " +
                    " FROM appointment ap JOIN center c ON ap.center_id=c.id " +
                    " WHERE ap.date != ?1 AND ap.time != ?2", nativeQuery = true)
    List<Center>findAllByDateTime(Date date, Time time);


}
