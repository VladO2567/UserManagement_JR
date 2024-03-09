package com.vdoderovic.usermanagementapp.Mapper;


import com.vdoderovic.usermanagementapp.DTO.Country.query.CountryDTO;
import com.vdoderovic.usermanagementapp.Entities.Country;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryDTO toDTO(Country country);
    Country toEntity(CountryDTO countryDTO);
    List<CountryDTO> toDTOList(List<Country> country);
}
