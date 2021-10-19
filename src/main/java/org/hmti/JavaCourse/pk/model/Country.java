package org.hmti.JavaCourse.pk.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hmti.JavaCourse.pk.CountryPK;

@Entity
@Table(name = "country")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private CountryPK pk;
    @Basic(optional = false)
    @Column(unique = true)
    private String countryName;
    private String countryDescription;

}
