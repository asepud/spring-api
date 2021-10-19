package org.hmti.JavaCourse.pk.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hmti.JavaCourse.pk.CityPK;
import org.hmti.JavaCourse.pk.DistrictPK;
import org.hmti.JavaCourse.pk.model.City;
import org.hmti.JavaCourse.pk.model.District;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDto {

    
    private DistrictPK districtPK;
    private String districtName;
    private String districtDescription;
    private CityPK cityId;

    public District createDistrict() {
        ModelMapper modelMapper = new ModelMapper();
        District district = modelMapper.map(this, District.class);
        district.setCityId(new City());
        district.getCityId().setCityPK(cityId);
    return district;
    }
}
