package com.vdoderovic.usermanagementapp.DTO.User.command;

import com.vdoderovic.usermanagementapp.DTO.City.command.CityProxyDTO;
import com.vdoderovic.usermanagementapp.DTO.Company.command.CompanyProxyDTO;
import com.vdoderovic.usermanagementapp.DTO.Country.command.CountryProxyDTO;
import com.vdoderovic.usermanagementapp.Enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank(message = "Username cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9.]{3,}$", message = "Username must be 3 to 16 characters long and can only contain letters, numbers and dots")
    private String username;
    @NotBlank(message = "Password cannot be blank")
    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])).{8,}$", message = "Password must be at least 8 characters long and contain at least 1 uppercase, 1 lowercase, 1 special character, and 1 digit")
    private String password;
    @NotBlank(message = "Email cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Email must be valid")
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
