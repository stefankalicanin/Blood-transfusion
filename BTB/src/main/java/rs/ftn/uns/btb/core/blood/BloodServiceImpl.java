package rs.ftn.uns.btb.core.blood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.core.blood.interfaces.BloodService;

@Service
public class BloodServiceImpl implements BloodService {

    public final BloodRepository _bloodRepo;

    @Autowired
    public BloodServiceImpl(BloodRepository _bloodRepo) { this._bloodRepo = _bloodRepo; }
}
