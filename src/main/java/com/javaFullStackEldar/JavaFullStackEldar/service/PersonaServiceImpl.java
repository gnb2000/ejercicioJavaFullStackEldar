package com.javaFullStackEldar.JavaFullStackEldar.service;

import com.javaFullStackEldar.JavaFullStackEldar.model.Persona;
import com.javaFullStackEldar.JavaFullStackEldar.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional
    public void save(Persona p) throws Exception {
        Persona pSave = personaRepository.save(p);
        if (pSave == null){
            throw new Exception("Hubo un problema al guardar a la persona "+p.getApellido());
        }
    }

    @Override
    @Transactional
    public void update(Persona p) throws Exception {
        Persona pSave = personaRepository.save(p);
        if (pSave == null){
            throw new Exception("Hubo un problema al actualizar a la persona "+p.getApellido());
        }
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        personaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findById(Long id) throws Exception {
        return personaRepository.findById(id).orElseThrow(() -> new Exception("No existe un invitado con id "+id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() throws Exception {
        List<Persona> p =  personaRepository.findAll();
        if (p == null) {
            throw new Exception("Hubo un problema al traer a las personas");
        } else {
            return p;
        }
    }

}
