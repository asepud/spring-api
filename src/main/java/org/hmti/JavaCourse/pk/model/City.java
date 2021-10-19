
package org.hmti.JavaCourse.pk.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hmti.JavaCourse.pk.CityPK;

@Entity
@Table(name = "city")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable {
    
    @EmbeddedId //menunjukan Primary key
    private CityPK cityPK;
    
    @Basic(optional = false)
    @Column(unique = true)
    private String cityName;
    private String cityDescription;
    @ManyToOne(optional = false)
    @JoinColumn(name = "province_id", referencedColumnName = "province_id")
    private Province provinceId;
}
