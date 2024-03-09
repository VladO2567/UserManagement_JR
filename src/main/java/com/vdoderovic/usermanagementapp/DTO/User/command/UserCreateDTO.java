package com.vdoderovic.usermanagementapp.DTO.User.command;

import com.vdoderovic.usermanagementapp.DTO.City.command.CityProxyDTO;
import com.vdoderovic.usermanagementapp.DTO.City.query.CityDTO;
import com.vdoderovic.usermanagementapp.DTO.Company.command.CompanyProxyDTO;
import com.vdoderovic.usermanagementapp.DTO.Country.command.CountryProxyDTO;
import com.vdoderovic.usermanagementapp.DTO.Country.query.CountryDTO;
import com.vdoderovic.usermanagementapp.Enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCreateDTO {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Gender gender;
    private LocalDate createdAt;
    private Boolean isActive;
    private CityProxyDTO cityProxy;
    private CountryProxyDTO countryProxy;
    private CompanyProxyDTO companyProxy;
}
