package org.hmti.JavaCourse.pk.model.dto.projection.repository.serv.impl.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.hmti.JavaCourse.pk.VillagePK;
import org.hmti.JavaCourse.pk.model.Village;
import org.hmti.JavaCourse.pk.model.dto.projection.repository.serv.impl.VillageServiceImpl;
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
@RequestMapping("/village")
public class VillageController {

    @Autowired
    private VillageServiceImpl villageServiceImpl;

    @GetMapping
    public List<Village> findAll() {
        return villageServiceImpl.findAll();
    }

    @GetMapping("/id")
    public Village findById(int villagePK) {
        return villageServiceImpl.findById(villagePK);
    }

    @GetMapping("/name")
    @ApiOperation(httpMethod = "GET", response = Village.class,
            value = "this url to get village by name")
    public List<Village> findByVillageName(@RequestParam(required = true)
            @ApiParam(defaultValue = "Kampung...", required = true,
                    value = "village to search") String villageName) {
        return villageServiceImpl.findByVillageName(villageName);
    }

    @PostMapping
    public void save(@RequestBody Village village) {
        villageServiceImpl.save(village);
    }

    @PutMapping
    public void update(@RequestBody Village village) {
        villageServiceImpl.update(village);
    }

    @DeleteMapping
    public void delete(@RequestBody VillagePK villagePK) {
        villageServiceImpl.delete(villagePK);
    }

}
