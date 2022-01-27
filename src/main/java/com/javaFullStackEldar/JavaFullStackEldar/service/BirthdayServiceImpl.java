package com.javaFullStackEldar.JavaFullStackEldar.service;

import com.javaFullStackEldar.JavaFullStackEldar.model.Birthday;
import com.javaFullStackEldar.JavaFullStackEldar.model.Invitado;
import com.javaFullStackEldar.JavaFullStackEldar.repository.BirthdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class BirthdayServiceImpl implements BirthdayService{

    @Autowired
    private BirthdayRepository birthdayRepository;

    @Override
    @Transactional
    public Long save(Birthday b) throws Exception {
        Birthday birthday = birthdayRepository.save(b);
        if (birthday == null){
            throw new Exception("Hubo un problema al guardar el birthday");
        }
        return birthday.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public Birthday findById(Long id) throws Exception {
        return birthdayRepository.findById(id).orElseThrow(() -> new Exception("No existe un birthday con id "+id));
    }

    @Override
    @Transactional
    public void addInvitado(Birthday b, Invitado i) throws Exception {
        b.addInvitado(i);
        Birthday bAct = birthdayRepository.save(b);
        if (bAct == null)
            throw new Exception("Hubo un problema al guardar al invitado "+i.getId());

    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        try{
            birthdayRepository.deleteById(id);
        } catch (EntityNotFoundException e){
            throw new Exception("Hubo un problema al borrar el birthday "+id);
        }
    }
}
