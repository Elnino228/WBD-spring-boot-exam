package com.codegym.springbootexam.repository;

import com.codegym.springbootexam.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City,Long> {
}
