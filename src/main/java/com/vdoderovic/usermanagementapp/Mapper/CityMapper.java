package com.vdoderovic.usermanagementapp.Mapper;

import com.vdoderovic.usermanagementapp.DTO.City.query.CityDTO;
import com.vdoderovic.usermanagementapp.Entities.City;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City toEntity(CityDTO cityDTO);
    CityDTO toDTO(City city);
    List<CityDTO> toDTOList(List<City> cityList);
}
