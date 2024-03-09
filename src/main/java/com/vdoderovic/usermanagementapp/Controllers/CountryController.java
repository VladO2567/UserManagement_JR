package com.vdoderovic.usermanagementapp.Controllers;

import com.vdoderovic.usermanagementapp.DTO.Country.query.CountryDTO;
import com.vdoderovic.usermanagementapp.Services.CountryService;
import com.vdoderovic.usermanagementapp.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryDTO>> getAll() {
        return new ResponseEntity<>(countryService.getAll(), HttpStatus.OK);
    }
}
