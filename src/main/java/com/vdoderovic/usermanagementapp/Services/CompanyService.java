package com.vdoderovic.usermanagementapp.Services;

import com.vdoderovic.usermanagementapp.DTO.Company.query.CompanyDTO;
import com.vdoderovic.usermanagementapp.Mapper.CompanyMapper;
import com.vdoderovic.usermanagementapp.Repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyMapper companyMapper;

    public List<CompanyDTO> getAll() {
        return companyMapper.toDTOList(companyRepository.findAll());
    }
}
