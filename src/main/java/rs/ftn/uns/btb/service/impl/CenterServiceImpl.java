package rs.ftn.uns.btb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.repository.CenterRepository;
import rs.ftn.uns.btb.service.CenterService;
import rs.ftn.uns.btb.model.Center;

@Service
public class CenterServiceImpl implements CenterService {

    public final CenterRepository _centerRepo;

    @Autowired
    public CenterServiceImpl(CenterRepository _centerRepo) { this._centerRepo = _centerRepo; }
}
