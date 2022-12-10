package rs.ftn.uns.btb.core.role;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findByName(String name);

    Role findOneById(Long id);
    
    @Query("select r from Role r where name in :names")
    List<Role> findAllByName(@Param("names") List<String> roleNames);
}
