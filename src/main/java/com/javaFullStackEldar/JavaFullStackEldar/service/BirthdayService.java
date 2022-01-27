package com.javaFullStackEldar.JavaFullStackEldar.service;

import com.javaFullStackEldar.JavaFullStackEldar.model.Birthday;
import com.javaFullStackEldar.JavaFullStackEldar.model.Invitado;

public interface BirthdayService {

    Long save(Birthday b) throws Exception;
    Birthday findById(Long id) throws Exception;
    void addInvitado(Birthday b, Invitado i) throws Exception;
    void delete(Long id) throws Exception;
}
