package com.javaFullStackEldar.JavaFullStackEldar.service;

import com.javaFullStackEldar.JavaFullStackEldar.model.Invitado;

import java.util.List;

public interface InvitadoService {

    void save(Invitado p);
    void update(Invitado p);
    void delete(Long id);
    Invitado findById(Long id);
    List<Invitado> findAll();
}
