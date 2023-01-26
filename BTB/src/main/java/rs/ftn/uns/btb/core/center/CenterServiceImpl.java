package rs.ftn.uns.btb.core.center;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ftn.uns.btb.core.center.interfaces.CenterService;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;
import java.sql.Time;

import java.util.ArrayList;
import java.util.HashMap;




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
    public List<Center> findAll() {
        List<Center> centers = _centerRepo.findAll();
        return centers;
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
                if (c.getGrade() >= grade) {
                    filteredCenters.add(c);
                }
            }
            return filteredCenters;
        }
        else{
            return centers;
        }
    }

    @Override
    public List<Center> findAllByDate(Date date) {
        return _centerRepo.findAllByDate(date);
    }




     @Override
    public List<Center> findAllByDateAndTime(Date date, Time time) {
        return _centerRepo.findAllByDateAndTime((java.sql.Date) date, time);
    }

    @Override
    public List<Center> findAllByDateTime(Date date, Time time){
        return _centerRepo.findAllByDateTime(date, time);
    }

}
