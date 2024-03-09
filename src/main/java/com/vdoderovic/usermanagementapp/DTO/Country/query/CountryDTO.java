package com.vdoderovic.usermanagementapp.DTO.Country.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CountryDTO {
    private String countryName;
    private Integer population;
}
