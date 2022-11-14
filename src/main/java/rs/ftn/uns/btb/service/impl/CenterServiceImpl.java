package rs.ftn.uns.btb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.repository.CenterRepository;
import rs.ftn.uns.btb.service.CenterService;
import rs.ftn.uns.btb.model.Center;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class CenterServiceImpl implements CenterService {

    public final CenterRepository _centerRepo;

    @Autowired
    public CenterServiceImpl(CenterRepository _centerRepo) {
        this._centerRepo = _centerRepo;
    }

    @Override
    public Center findOne(Long id) {
        return this._centerRepo.findById(id).orElseGet(null);
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


    public List<Center> findAll() {
        return _centerRepo.findAll();

    }

    public static HashMap<String, Center> centers = new HashMap<String, Center>();

    @Override
    public List<Center> findByNameAndAddress(String name, String address, double grade) {
        List<Center> centers = new ArrayList<>();
        if (name != "" && address != "") centers = _centerRepo.findByNameContainingIgnoreCaseAndAddressContainingIgnoreCase(name, address);
        else if (name != "") centers = _centerRepo.findByNameContainingIgnoreCase(name);
        else if (address != null) centers = _centerRepo.findByAddressContainingIgnoreCase(address);
        else centers = _centerRepo.findAll();

        if (grade != 0) {
            List filteredCenters = new ArrayList();
            for (Center c : centers) {
                if (c.getGrade() == grade) {
                    filteredCenters.add(c);
                }
            }
            return filteredCenters;
        }
        else{
            return centers;
        }
    }

}
