package com.javaFullStackEldar.JavaFullStackEldar.controller;

import com.javaFullStackEldar.JavaFullStackEldar.dto.BirthdayDTO;
import com.javaFullStackEldar.JavaFullStackEldar.dto.InvitadoDTO;
import com.javaFullStackEldar.JavaFullStackEldar.model.Birthday;
import com.javaFullStackEldar.JavaFullStackEldar.model.Invitado;
import com.javaFullStackEldar.JavaFullStackEldar.model.Persona;
import com.javaFullStackEldar.JavaFullStackEldar.repository.BirthdayRepository;
import com.javaFullStackEldar.JavaFullStackEldar.repository.InvitadoRepository;
import com.javaFullStackEldar.JavaFullStackEldar.service.BirthdayService;
import com.javaFullStackEldar.JavaFullStackEldar.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/birthdays")
@CrossOrigin(origins = "http://localhost:3000")
public class BirthdayControlller {

    @Autowired
    private BirthdayService birthdayService;

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public void save(@RequestBody BirthdayDTO b){
        birthdayService.save(new Birthday(b.getFecha()));
    }

    @PutMapping
    public void addInvitado(@RequestBody InvitadoDTO i){
        Birthday b = birthdayService.findById(i.getIdBirthday());
        Persona p = personaService.findById(i.getIdPersona());
        Invitado invitado = new Invitado(b,p);
        birthdayService.addInvitado(b,invitado);
    }
}
