package com.javaFullStackEldar.JavaFullStackEldar.repository;

import com.javaFullStackEldar.JavaFullStackEldar.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long> {


}
