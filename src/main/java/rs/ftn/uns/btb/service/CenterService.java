package rs.ftn.uns.btb.service;
import rs.ftn.uns.btb.model.Center;
public interface CenterService {

    Center findOne(Long id);

    Center update(Center center) throws Exception;
}
