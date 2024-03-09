package com.vdoderovic.usermanagementapp.Controllers;

import com.vdoderovic.usermanagementapp.DTO.City.query.CityDTO;
import com.vdoderovic.usermanagementapp.Services.CityService;
import com.vdoderovic.usermanagementapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<CityDTO>> getAll() {
        return new ResponseEntity<List<CityDTO>>(cityService.getAll(), HttpStatus.OK);
    }
}
