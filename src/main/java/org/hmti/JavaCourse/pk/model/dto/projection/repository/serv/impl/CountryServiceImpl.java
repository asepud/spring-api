package org.hmti.JavaCourse.pk.model.dto.projection.repository.serv.impl;

import java.util.List;
import org.hmti.JavaCourse.pk.CountryPK;
import org.hmti.JavaCourse.pk.model.Country;
import org.hmti.JavaCourse.pk.model.dto.projection.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class CountryServiceImpl {

    @Autowired
    private CountryRepo countryRepo;


    public void save(Country country) {
        if (countryRepo.findById(country.getPk()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id sudah ada");
        }
        countryRepo.save(country);
    }

    public void update(Country country) {
        if (!countryRepo.findById(country.getPk()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id tidak ada");
        }
        countryRepo.save(country);
    }

    public void delete(CountryPK countryPK) {
        countryRepo.deleteById(countryPK);
    }

    public List<Country> findAll() {
        return countryRepo.findAll();
    }

    public Country findByID(int countryPK) {
        CountryPK pK = new CountryPK(countryPK);
        return countryRepo.findById(pK).get();
    }
    
    public List<Country> findByCountryName(String countryName){
        return countryRepo.findByCountryName(countryName);
    }
}
