package org.hmti.JavaCourse.pk.model.dto.projection.repository.serv.impl.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.hmti.JavaCourse.pk.DistrictPK;
import org.hmti.JavaCourse.pk.model.District;
import org.hmti.JavaCourse.pk.model.dto.DistrictDto;
import org.hmti.JavaCourse.pk.model.dto.projection.repository.serv.impl.DistrictServiceImpl;
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
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    private DistrictServiceImpl districtServiceImpl;

    @GetMapping
    public List<District> findAll() {
        return districtServiceImpl.findAll();
    }

    @GetMapping("/name")
    @ApiOperation(httpMethod = "GET", response = List.class,
            value = "this url to get district by name")
    public List<District> findByDistrictName(
            @RequestParam(required = true)
            @ApiParam(defaultValue = "ancol", required = true,
                    value = "this url to get district by name") String districtName) {
        return districtServiceImpl.findByDistrictName(districtName);
    }

    @GetMapping("/id")
    @ApiOperation(httpMethod = "GET", response = List.class,
            value = "this url to get district by id")
    public void findById(DistrictPK districtPK) {
        districtServiceImpl.findById(districtPK);
    }

    @PostMapping
    public void save(@RequestBody District district) {
        districtServiceImpl.save(district);
    }

    @PostMapping("/dto")
    public void save(@RequestBody DistrictDto districtDto) {
        districtServiceImpl.save(districtDto);
    }

    @PutMapping
    public void update(@RequestBody District district) {
        districtServiceImpl.update(district);
    }

    @DeleteMapping
    public void delete(@RequestBody DistrictPK districtPK) {
        districtServiceImpl.delete(districtPK);
    }
}
