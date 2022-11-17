package rs.ftn.uns.btb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rs.ftn.uns.btb.model.Center;

import java.util.List;

public interface CenterRepository extends JpaRepository<Center, Long> {

    public Center findOneById(Long id);

    // public Center findByName(String name);

    public List<Center> findAll();

    public List<Center> findByNameContainingIgnoreCase(String name);

    public List<Center> findByAddressContainingIgnoreCase(String address);

    public List<Center> findByNameContainingIgnoreCaseAndAddressContainingIgnoreCase(String name, String address);
    
}
