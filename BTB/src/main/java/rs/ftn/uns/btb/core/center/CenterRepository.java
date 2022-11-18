package rs.ftn.uns.btb.core.center;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.core.center.Center;

import java.util.List;

public interface CenterRepository extends JpaRepository<Center, Long> {

    public Center findOneById(Long id);

    // public Center findByName(String name);

    public List<Center> findAll();

    public List<Center> findByNameContainingIgnoreCase(String name);

    public List<Center> findByAddressContainingIgnoreCase(String address);

    public List<Center> findByNameContainingIgnoreCaseAndAddressContainingIgnoreCase(String name, String address);
    
}
