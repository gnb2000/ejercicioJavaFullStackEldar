package com.javaFullStackEldar.JavaFullStackEldar.service;

import com.javaFullStackEldar.JavaFullStackEldar.model.Persona;

import java.util.List;

public interface PersonaService {

    void save(Persona p) throws Exception;
    void update(Persona p) throws Exception;
    void delete(Long id) throws Exception;
    Persona findById(Long id) throws Exception;
    List<Persona> findAll() throws Exception;

}
