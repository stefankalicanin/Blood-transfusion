package rs.ftn.uns.btb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.model.User;
import rs.ftn.uns.btb.repository.CenterRepository;
import rs.ftn.uns.btb.service.CenterService;
import rs.ftn.uns.btb.model.Center;

@Service
public class CenterServiceImpl implements CenterService {

    public final CenterRepository _centerRepo;

    @Autowired
    public CenterServiceImpl(CenterRepository _centerRepo) { this._centerRepo = _centerRepo; }

    @Override
    public Center findOne(Long id) {
        return this._centerRepo.findById(id).orElseGet(null);
    }
    @Override
    public Center create(Center center) throws Exception {
        Center newCenter = this._centerRepo.save(center);
        return newCenter;
    }
    @Override
    public Center update(Center center) throws Exception {
        Center centerToUpdate = this._centerRepo.findOneById(center.getId());

        if (centerToUpdate == null) {
            throw new Exception("Center does not exist.");
        }

        centerToUpdate.setName(center.getName());
        centerToUpdate.setAddress(center.getAddress());
        centerToUpdate.setDescription(center.getDescription());
        centerToUpdate.setGrade(center.getGrade());

        Center updatedCenter = _centerRepo.save(centerToUpdate);
        return updatedCenter;

    }
}
