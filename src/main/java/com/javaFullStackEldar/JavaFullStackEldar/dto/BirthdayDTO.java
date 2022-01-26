package com.javaFullStackEldar.JavaFullStackEldar.dto;

import java.time.LocalDate;

public class BirthdayDTO {

    private Long id;
    private LocalDate fecha;

    public BirthdayDTO(Long id, LocalDate fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
