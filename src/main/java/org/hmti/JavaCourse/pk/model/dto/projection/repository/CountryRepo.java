package org.hmti.JavaCourse.pk.model.dto.projection.repository;

import java.util.List;
import org.hmti.JavaCourse.pk.CountryPK;
import org.hmti.JavaCourse.pk.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country, CountryPK> {

    List<Country> findByCountryName(String countryName);
}
