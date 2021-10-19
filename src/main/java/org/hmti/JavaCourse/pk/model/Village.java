
package org.hmti.JavaCourse.pk.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hmti.JavaCourse.pk.VillagePK;

@Entity
@Table(name = "village")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Village implements Serializable {
    
    @EmbeddedId
    private VillagePK villagePK;
    @Basic(optional = false)
    private String villageName;
    private String villageDescription;
    @ManyToOne
    @JoinColumn(name = "district_id", referencedColumnName = "district_id")
    private District district_id;
    
}
