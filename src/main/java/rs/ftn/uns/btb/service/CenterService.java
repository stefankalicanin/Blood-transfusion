package rs.ftn.uns.btb.service;
import rs.ftn.uns.btb.model.Center;

import java.util.List;

public interface CenterService {

    Center findOne(Long id);

    Center update(Center center) throws Exception;

}
