package com.codegym.springbootexam.service.impl;

import com.codegym.springbootexam.model.Nation;
import com.codegym.springbootexam.repository.NationRepository;
import com.codegym.springbootexam.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class NationServiceImpl implements NationService {

    @Autowired
    private NationRepository nationRepository;

    @Override
    public Iterable<Nation> findAll() {
        return nationRepository.findAll();
    }

    @Override
    public Nation findById(Long id) {
        return nationRepository.findById(id).get();
    }

    @Override
    public void save(Nation nation) {
        nationRepository.save(nation);
    }

    @Override
    public void remove(Long id) {
        nationRepository.deleteById(id);
    }
}
