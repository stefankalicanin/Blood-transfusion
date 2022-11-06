package rs.ftn.uns.btb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.repository.BloodRepository;
import rs.ftn.uns.btb.service.BloodService;
import rs.ftn.uns.btb.model.Blood;

@Service
public class BloodServiceImpl implements BloodService {

    public final BloodRepository _bloodRepo;

    @Autowired
    public BloodServiceImpl(BloodRepository _bloodRepo) { this._bloodRepo = _bloodRepo; }
}
