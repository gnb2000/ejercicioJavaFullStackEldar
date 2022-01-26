package com.javaFullStackEldar.JavaFullStackEldar.repository;

import com.javaFullStackEldar.JavaFullStackEldar.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
