package com.vdoderovic.usermanagementapp.Services;

import com.vdoderovic.usermanagementapp.DTO.Country.query.CountryDTO;
import com.vdoderovic.usermanagementapp.Mapper.CountryMapper;
import com.vdoderovic.usermanagementapp.Repositories.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {


    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;


    public List<CountryDTO> getAll() {
        return countryMapper.toDTOList(countryRepository.findAll());
    }
}
