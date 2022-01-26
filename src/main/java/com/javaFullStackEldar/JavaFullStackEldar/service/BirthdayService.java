package com.javaFullStackEldar.JavaFullStackEldar.service;

import com.javaFullStackEldar.JavaFullStackEldar.model.Birthday;
import com.javaFullStackEldar.JavaFullStackEldar.model.Invitado;

public interface BirthdayService {

    Long save(Birthday b);
    Birthday findById(Long id);
    void addInvitado(Birthday b, Invitado i);
    void delete(Long id);
}
