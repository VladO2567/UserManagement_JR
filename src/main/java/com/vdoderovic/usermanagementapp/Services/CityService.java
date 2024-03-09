package com.vdoderovic.usermanagementapp.Services;

import com.vdoderovic.usermanagementapp.DTO.City.query.CityDTO;
import com.vdoderovic.usermanagementapp.Mapper.CityMapper;
import com.vdoderovic.usermanagementapp.Repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CityMapper cityMapper;

    public List<CityDTO> getAll() {
        return cityMapper.toDTOList(cityRepository.findAll());
    }
}
