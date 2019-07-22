package com.codegym.springbootexam.service;

import com.codegym.springbootexam.model.Nation;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface NationService {
    Iterable<Nation> findAll();

    Nation findById(Long id);

    void save(Nation nation);

    void remove(Long id);
}
