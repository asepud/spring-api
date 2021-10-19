package org.hmti.JavaCourse.pk.model.dto.projection.repository.serv.impl;

import java.util.List;
import org.hmti.JavaCourse.pk.VillagePK;
import org.hmti.JavaCourse.pk.model.Village;
import org.hmti.JavaCourse.pk.model.dto.projection.repository.VillageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class VillageServiceImpl {
    
    @Autowired
    private VillageRepo villageRepo;
    
    public List<Village> findAll() {
        return villageRepo.findAll();
    }
    
    public Village findById(int villagePK) {
        VillagePK vpk = new VillagePK(villagePK);
        return villageRepo.findById(vpk).get();
    }
    
    public List<Village> findByVillageName(String villageName) {
        return villageRepo.findByVillageName(villageName);
    }
    
   
    public void save(Village village) {
        if (villageRepo.findById(village.getVillagePK()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id already exist");
        }
        villageRepo.save(village);
    }
    
    public void update(Village village) {
        if (!villageRepo.findById(village.getVillagePK()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id not found");
        }
        villageRepo.save(village);
    }
    
    public void delete(VillagePK villagePK) {
        villageRepo.deleteById(villagePK);
    }
}
