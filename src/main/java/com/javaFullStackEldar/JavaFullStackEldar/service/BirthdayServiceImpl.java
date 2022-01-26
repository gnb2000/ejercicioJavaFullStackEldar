package com.javaFullStackEldar.JavaFullStackEldar.service;

import com.javaFullStackEldar.JavaFullStackEldar.model.Birthday;
import com.javaFullStackEldar.JavaFullStackEldar.repository.BirthdayRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BirthdayServiceImpl implements BirthdayService{

    @Autowired
    private BirthdayRepository birthdayRepository;

    @Override
    public void save(Birthday b) {
        birthdayRepository.save(b);
    }
}
