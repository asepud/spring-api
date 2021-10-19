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
import org.hmti.JavaCourse.pk.ProvincePK;

@Entity
@Table(name = "province")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private ProvincePK provincePK;

    @Basic(optional = false)
    @Column(unique = true)
    private String provinceName;
    private String provinceDescription;
    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Country countryId;

}
