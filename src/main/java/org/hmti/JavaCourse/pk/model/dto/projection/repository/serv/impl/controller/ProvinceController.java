package org.hmti.JavaCourse.pk.model.dto.projection.repository.serv.impl.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.hmti.JavaCourse.pk.ProvincePK;
import org.hmti.JavaCourse.pk.model.Province;
import org.hmti.JavaCourse.pk.model.dto.projection.repository.serv.impl.ProvinceServiceImpl;
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
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    private ProvinceServiceImpl provinceServiceImpl;

    @GetMapping
    public List<Province> findAll() {
        return provinceServiceImpl.findAll();
    }
    
    @GetMapping("/id")
    @ApiOperation(httpMethod = "GET", response = List.class,
            value = "this url to get province by id")
    public Province findById(int provincePk) {
      return provinceServiceImpl.findByID(provincePk);
    }
    
    @GetMapping("/name")
    @ApiOperation(httpMethod = "GET", response = List.class, 
            value = "this url to get province by name")
    public List<Province> findProvinceByName(
            @RequestParam (required = true)
            @ApiParam(defaultValue = "Jakarta", required = true,
                    value = "name province") String ProvinceName){
    return provinceServiceImpl.findProvinceByName(ProvinceName);
    }

    @PostMapping
    public void save(@RequestBody Province province) {
        provinceServiceImpl.save(province);
    }

    @PutMapping
    public void update(@RequestBody Province province) {
        provinceServiceImpl.update(province);
    }
    
    @DeleteMapping
    public void delete(@RequestBody ProvincePK provincePK) {
        provinceServiceImpl.delete(provincePK);
    }

}
