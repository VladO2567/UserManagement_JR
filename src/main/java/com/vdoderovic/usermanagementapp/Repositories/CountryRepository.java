package com.vdoderovic.usermanagementapp.Repositories;

import com.vdoderovic.usermanagementapp.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
