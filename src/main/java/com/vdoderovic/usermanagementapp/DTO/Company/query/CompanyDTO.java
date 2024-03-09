package com.vdoderovic.usermanagementapp.DTO.Company.query;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {
    private String companyName;
    private Integer numOfEmployees;
}
