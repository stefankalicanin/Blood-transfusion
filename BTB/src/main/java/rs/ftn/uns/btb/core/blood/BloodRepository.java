package rs.ftn.uns.btb.core.blood;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.uns.btb.core.blood.interfaces.BloodType;

public interface BloodRepository extends JpaRepository<Blood, String> {

    Blood findOneByCenterIdAndType(Long id, BloodType type);
}
