package org.hmti.JavaCourse.pk.model.dto.projection.repository.serv.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.hmti.JavaCourse.pk.ProvincePK;
import org.hmti.JavaCourse.pk.model.Province;
import org.hmti.JavaCourse.pk.model.dto.projection.repository.ProvinceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class ProvinceServiceImpl {

    @Autowired
    private ProvinceRepo provinceRepo;


    public void save(Province province) {
        if (provinceRepo.findById(province.getProvincePK()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id already exist");
        }
        provinceRepo.save(province);
    }

    public void update(Province province) {
        if (!provinceRepo.findById(province.getProvincePK()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id not found");
        }
        provinceRepo.save(province);
    }

    public void delete(ProvincePK provincePK) {
        provinceRepo.deleteById(provincePK);
    }

    public List<Province> findAll() {
        return provinceRepo.findAll();
    }

    public Province findByID(int provincePK) {
        ProvincePK ppk = new ProvincePK(provincePK);
        return provinceRepo.findById(ppk).get();
    }

    public List<Province> findProvinceByName(String provinceName) {
        return provinceRepo.findByProvinceName(provinceName);
    }
}
