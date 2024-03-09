package com.vdoderovic.usermanagementapp.DTO.User.query;

import com.vdoderovic.usermanagementapp.DTO.Company.query.CompanyDTO;
import com.vdoderovic.usermanagementapp.Enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserWCompDTO {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Gender gender;
    private LocalDate createdAt;
    private Boolean isActive;
    private CompanyDTO companyDTO;
}
