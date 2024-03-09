package com.vdoderovic.usermanagementapp.Controllers;

import com.vdoderovic.usermanagementapp.DTO.Company.query.CompanyDTO;
import com.vdoderovic.usermanagementapp.Services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAll() {
        return ResponseEntity.ok(companyService.getAll());
    }
}
