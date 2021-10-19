package org.hmti.JavaCourse.pk.model.dto.projection.repository;

import java.util.List;
import org.hmti.JavaCourse.pk.ProvincePK;
import org.hmti.JavaCourse.pk.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepo extends JpaRepository<Province, ProvincePK>{

    List<Province> findByProvinceName(String provinceName);

}
