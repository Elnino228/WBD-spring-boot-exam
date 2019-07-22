package com.codegym.springbootexam.repository;

import com.codegym.springbootexam.model.Nation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NationRepository extends PagingAndSortingRepository<Nation,Long> {
}
