package com.javaFullStackEldar.JavaFullStackEldar.dto;

import java.time.LocalDate;

public class PersonaDTO {

    private Long idPersona;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;

    public PersonaDTO(Long idPersona, String nombre, String apellido, LocalDate fechaNac) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }
}
