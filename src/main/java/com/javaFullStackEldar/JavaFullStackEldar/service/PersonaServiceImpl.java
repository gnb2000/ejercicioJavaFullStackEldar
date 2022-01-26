package com.javaFullStackEldar.JavaFullStackEldar.service;

import com.javaFullStackEldar.JavaFullStackEldar.model.Persona;
import com.javaFullStackEldar.JavaFullStackEldar.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional
    public void save(Persona p) {
        personaRepository.save(p);
    }

    @Override
    @Transactional
    public void update(Persona p) {
        personaRepository.save(p);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

}
