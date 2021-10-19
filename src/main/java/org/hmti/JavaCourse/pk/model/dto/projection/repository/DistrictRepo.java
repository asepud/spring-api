package org.hmti.JavaCourse.pk.model.dto.projection.repository;

import java.util.List;
import org.hmti.JavaCourse.pk.DistrictPK;
import org.hmti.JavaCourse.pk.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepo extends JpaRepository<District, DistrictPK> {

    List<District> findByDistrictName(String districtName);
}
