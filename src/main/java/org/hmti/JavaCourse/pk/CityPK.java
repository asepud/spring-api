package org.hmti.JavaCourse.pk;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityPK implements Serializable {

    @Basic(optional = false) //optional false = not null
    @Column(name = "city_id", length = 10)
    private Integer city_id;
}
