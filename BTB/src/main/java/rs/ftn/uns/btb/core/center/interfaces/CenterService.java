package rs.ftn.uns.btb.core.center.interfaces;
import rs.ftn.uns.btb.core.center.Center;


import java.util.List;

public interface CenterService {

    Center findOne(Long id);

    Center update(Center center) throws Exception;
    Center create(Center center) throws Exception;

    List<Center> findAll();
    List<Center> findByNameAndAddress(String name, String address, double grade);
}
