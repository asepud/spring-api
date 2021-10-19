
package org.hmti.JavaCourse.pk.model.dto.projection.repository;

import java.util.List;
import org.hmti.JavaCourse.pk.VillagePK;
import org.hmti.JavaCourse.pk.model.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageRepo extends JpaRepository<Village, VillagePK>{
    List<Village> findByVillageName(String villageName);
}
