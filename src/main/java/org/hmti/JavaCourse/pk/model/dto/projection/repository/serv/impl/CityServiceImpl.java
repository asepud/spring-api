package org.hmti.JavaCourse.pk.model.dto.projection.repository.serv.impl;

import java.util.List;
import org.hmti.JavaCourse.pk.CityPK;
import org.hmti.JavaCourse.pk.model.City;
import org.hmti.JavaCourse.pk.model.dto.projection.repository.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class CityServiceImpl {

    @Autowired
    private CityRepo cityRepo;

    public List<City> findAll() {
        return cityRepo.findAll();
    }

    public City findById(int cityPK) {
        CityPK cpk = new CityPK(cityPK);
        return cityRepo.findById(cpk).get();
    }

    public List<City> findCityByName(String cityName) {
        return cityRepo.findByCityName(cityName);
    }

    public void saveOrUpdate(City city) {
        cityRepo.save(city);
    }

    public void save(City city) {
        if (cityRepo.findById(city.getCityPK()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id already exist");
        }
        cityRepo.save(city);
    }
    

    public void update(City city) {
        if (!cityRepo.findById(city.getCityPK()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id not found");
        }
        cityRepo.save(city);
    }

    public void delete(CityPK cityPK) {
        cityRepo.deleteById(cityPK);
    }

}
