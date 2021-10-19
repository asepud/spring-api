package org.hmti.JavaCourse.pk.model.dto.projection.repository.serv.impl.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.hmti.JavaCourse.pk.CountryPK;
import org.hmti.JavaCourse.pk.model.Country;
import org.hmti.JavaCourse.pk.model.dto.projection.repository.serv.impl.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryServiceImpl countryServiceImpl;

    @GetMapping
    public List<Country> findAll() {
        return countryServiceImpl.findAll();
    }

    @PostMapping
    public void save(@RequestBody Country country) {
        countryServiceImpl.save(country);
    }
    @GetMapping("/id")
    @ApiOperation(httpMethod = "GET", response = List.class,
            value = "this url to get city by id")
    public Country findById(int cityPK) {
        return countryServiceImpl.findByID(cityPK);
        
    }
    @GetMapping("/name")
    @ApiOperation(httpMethod = "GET", response = List.class,
            value = "Ini url untuk mendapatkan daftar negara berdasarkan namanya")
    public List<Country> findByCountryName(
            @RequestParam(required = true)
            @ApiParam(defaultValue = "indonesia", required = true,
                    value = "nama negara yang akan dicari") String countryName) {
        return countryServiceImpl.findByCountryName(countryName);
    }

    @PutMapping
    public void update(@RequestBody Country country) {
        countryServiceImpl.update(country);
    }

    @DeleteMapping
    public void delete(@RequestBody CountryPK countryPK) {
        countryServiceImpl.delete(countryPK);
    }
}
