package org.hmti.JavaCourse.pk.model.dto.projection.repository.serv.impl;

import java.util.List;
import org.hmti.JavaCourse.pk.DistrictPK;
import org.hmti.JavaCourse.pk.model.District;
import org.hmti.JavaCourse.pk.model.dto.DistrictDto;
import org.hmti.JavaCourse.pk.model.dto.projection.repository.DistrictRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class DistrictServiceImpl {

    @Autowired
    private DistrictRepo districtRepo;

    public List<District> findAll() {
        return districtRepo.findAll();
    }

    public District findById(DistrictPK districtPK) {
        return districtRepo.findById(districtPK).get();
    }

    public List<District> findByDistrictName(String districtName) {
        return districtRepo.findByDistrictName(districtName);
    }

    public void saveOrUpdate(District district) {
        districtRepo.save(district);
    }

    public void save(District district) {
        if (districtRepo.findById(district.getDistrictPK()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id already exist");
        }
        districtRepo.save(district);
    }
    
    public void save(DistrictDto districtDto) {
        if (districtRepo.findById(districtDto.getDistrictPK()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id already exist");
        }
        districtRepo.save(districtDto.createDistrict());
    }

    public void update(District district) {
        if (!districtRepo.findById(district.getDistrictPK()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id not found");

        }
        districtRepo.save(district);
    }

    public void delete(DistrictPK districtPK) {
        districtRepo.deleteById(districtPK);
    }
}
