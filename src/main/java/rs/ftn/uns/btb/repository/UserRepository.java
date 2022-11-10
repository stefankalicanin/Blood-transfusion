package rs.ftn.uns.btb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.model.Person;
import rs.ftn.uns.btb.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByFirstNameAndLastNameAllIgnoringCase(String firstName, String lastName);


    public User findOneById(Long id);

}
