package com.vdoderovic.usermanagementapp.Repositories;

import com.vdoderovic.usermanagementapp.Entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
