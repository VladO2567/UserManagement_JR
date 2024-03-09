package com.vdoderovic.usermanagementapp.Mapper;

import com.vdoderovic.usermanagementapp.DTO.Company.query.CompanyDTO;
import com.vdoderovic.usermanagementapp.Entities.Company;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    Company toEntity(CompanyDTO companyDTO);
    CompanyDTO toDTO(Company company);
    List<CompanyDTO> toDTOList(List<Company> companyList);
}
