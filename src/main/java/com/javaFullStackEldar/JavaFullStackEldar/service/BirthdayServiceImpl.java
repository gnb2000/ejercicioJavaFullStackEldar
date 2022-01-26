package com.javaFullStackEldar.JavaFullStackEldar.service;

import com.javaFullStackEldar.JavaFullStackEldar.model.Birthday;
import com.javaFullStackEldar.JavaFullStackEldar.model.Invitado;
import com.javaFullStackEldar.JavaFullStackEldar.repository.BirthdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BirthdayServiceImpl implements BirthdayService{

    @Autowired
    private BirthdayRepository birthdayRepository;

    @Override
    @Transactional
    public Long save(Birthday b) {
        Birthday birthday = birthdayRepository.save(b);
        return birthday.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public Birthday findById(Long id) {
        return birthdayRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void addInvitado(Birthday b, Invitado i) {
        b.addInvitado(i);
        birthdayRepository.save(b);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        birthdayRepository.deleteById(id);
    }
}
