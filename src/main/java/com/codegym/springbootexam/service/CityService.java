package com.codegym.springbootexam.service;

import com.codegym.springbootexam.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CityService {
    Page<City> findAll(Pageable pageable);

    City findById(Long id);

    void save(City city);

    void remove(Long id);
}
