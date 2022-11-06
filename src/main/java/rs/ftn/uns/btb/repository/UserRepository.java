package rs.ftn.uns.btb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
