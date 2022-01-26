package com.javaFullStackEldar.JavaFullStackEldar.service;

import com.javaFullStackEldar.JavaFullStackEldar.model.Invitado;
import com.javaFullStackEldar.JavaFullStackEldar.repository.InvitadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class InvitadoServiceImpl implements InvitadoService{

    @Autowired
    private InvitadoRepository invitadoRepository;


    @Override
    @Transactional
    public void save(Invitado p) {
        invitadoRepository.save(p);
    }

    @Override
    @Transactional
    public void update(Invitado p) {
        invitadoRepository.save(p);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        invitadoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Invitado findById(Long id) {
        return invitadoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Invitado> findAll() {
        return invitadoRepository.findAll();
    }
}
