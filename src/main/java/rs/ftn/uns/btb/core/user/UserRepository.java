package rs.ftn.uns.btb.core.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findOneById(Long id);
    public List<User> findAll();
    @Query(value = "SELECT u "+
            "FROM users u "+
            "WHERE LOWER(u.email)='string@'",nativeQuery = true)// AND u.password = ?2",nativeQuery = true)
    public User checkLogin(String email, String password);
    public User findOneByEmailAndPassword(String email, String password);
    public List<User> findByFirstNameAndLastNameAllIgnoringCase(String firstName, String lastName);
}
