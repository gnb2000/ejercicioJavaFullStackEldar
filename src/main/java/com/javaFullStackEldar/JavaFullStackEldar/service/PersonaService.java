package com.javaFullStackEldar.JavaFullStackEldar.service;

import com.javaFullStackEldar.JavaFullStackEldar.model.Persona;

import java.util.List;

public interface PersonaService {

    void save(Persona p);
    void update(Persona p);
    void delete(Long id);
    Persona findById(Long id);
    List<Persona> findAll();

}
