package org.hmti.JavaCourse.pk.model.dto.projection.repository.serv.impl.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.hmti.JavaCourse.pk.CityPK;
import org.hmti.JavaCourse.pk.model.City;
import org.hmti.JavaCourse.pk.model.dto.projection.repository.serv.impl.CityServiceImpl;
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
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityServiceImpl cityServiceImpl;

    @GetMapping
    public List<City> findAll() {
        return cityServiceImpl.findAll();
    }

    @GetMapping("/id")
    @ApiOperation(httpMethod = "GET", response = List.class,
            value = "this url to get city by id")
    public City findById(int cityPK) {
        return cityServiceImpl.findById(cityPK);
        
    }
    
    @GetMapping("/name")
    @ApiOperation(httpMethod = "GET", response = List.class,
            value = "this url to get city by name")
    public List<City> findByCityName(
            @RequestParam(required = true)
            @ApiParam(defaultValue = "city", required = true,
             value = "city name will be search") String cityName) {
        return cityServiceImpl.findCityByName(cityName);
    }

    @PostMapping
    public void save(@RequestBody City city) {
        cityServiceImpl.save(city);
    }

    @PutMapping
    public void update(@RequestBody City city) {
        cityServiceImpl.update(city);
    }

    @DeleteMapping
    public void delete(@RequestBody CityPK cityPK) {
        cityServiceImpl.delete(cityPK);
    }
}
