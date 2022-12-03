package rs.ftn.uns.btb.core.role;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findByName(String name);

    Role findOneById(Long id);
    
}
