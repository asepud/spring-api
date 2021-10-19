package org.hmti.JavaCourse.pk.model.dto.projection.repository;

import java.util.List;
import org.hmti.JavaCourse.pk.CityPK;
import org.hmti.JavaCourse.pk.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<City, CityPK> {

    List<City> findByCityName(String cityName);
}
