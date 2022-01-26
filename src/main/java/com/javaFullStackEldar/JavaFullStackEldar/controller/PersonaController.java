package com.javaFullStackEldar.JavaFullStackEldar.controller;

import com.javaFullStackEldar.JavaFullStackEldar.dto.PersonaDTO;
import com.javaFullStackEldar.JavaFullStackEldar.model.Persona;
import com.javaFullStackEldar.JavaFullStackEldar.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:3000")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public void save(@RequestBody PersonaDTO p){
        Persona persona = new Persona(p.getNombre(),p.getApellido(),p.getFechaNac());
        personaService.save(persona);
    }

    @PutMapping
    public void update(@RequestBody PersonaDTO p){
        Persona persona = new Persona(p.getIdPersona(),p.getNombre(),p.getApellido(),p.getFechaNac());
        personaService.save(persona);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        personaService.delete(id);
    }

    @GetMapping
    public List<PersonaDTO> getAll(){
        List<Persona> personas = personaService.findAll();
        List<PersonaDTO> personasDTO = new ArrayList<>();
        for (Persona p : personas)
            personasDTO.add(p.toDTO());
        return personasDTO;
    }


}
