package com.javaFullStackEldar.JavaFullStackEldar.service;

import com.javaFullStackEldar.JavaFullStackEldar.model.Invitado;
import com.javaFullStackEldar.JavaFullStackEldar.repository.InvitadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class InvitadoServiceImpl implements InvitadoService{

    @Autowired
    private InvitadoRepository invitadoRepository;


    @Override
    @Transactional
    public void save(Invitado p) throws Exception {
        Invitado i = invitadoRepository.save(p);
        if (i == null){
            throw new Exception("Hubo un problema al guardar al invitado "+p.getId());
        }
    }

    @Override
    @Transactional
    public void update(Invitado p) throws Exception {
        Invitado i = invitadoRepository.save(p);
        if (i == null){
            throw new Exception("Hubo un problema al guardar al invitado "+p.getId());
        }
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        try {
            invitadoRepository.deleteById(id);
        } catch (EntityNotFoundException e){
            throw new Exception("Hubo un problema al borrar el invitado "+id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Invitado findById(Long id) throws Exception {
        return invitadoRepository.findById(id).orElseThrow(() -> new Exception("No existe un invitado con id "+id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Invitado> findAll() throws Exception {

        List<Invitado> i = invitadoRepository.findAll();
        if (i == null){
            throw new Exception("Hubo un problema al traer a todos los invitados");
        } else {
            return i;
        }
    }
}
