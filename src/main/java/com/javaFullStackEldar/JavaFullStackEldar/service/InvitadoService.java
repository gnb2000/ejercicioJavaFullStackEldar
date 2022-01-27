package com.javaFullStackEldar.JavaFullStackEldar.service;

import com.javaFullStackEldar.JavaFullStackEldar.model.Invitado;

import java.util.List;

public interface InvitadoService {

    void save(Invitado p) throws Exception;
    void update(Invitado p) throws Exception;
    void delete(Long id) throws Exception;
    Invitado findById(Long id) throws Exception;
    List<Invitado> findAll() throws Exception;
}
