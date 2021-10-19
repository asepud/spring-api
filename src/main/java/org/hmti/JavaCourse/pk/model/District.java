package org.hmti.JavaCourse.pk.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hmti.JavaCourse.pk.DistrictPK;

@Entity
@Table(name = "district")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class District implements Serializable {

    @EmbeddedId
    private DistrictPK districtPK;
    private String districtName;
    private String districtDescription;
    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private City cityId;
}
