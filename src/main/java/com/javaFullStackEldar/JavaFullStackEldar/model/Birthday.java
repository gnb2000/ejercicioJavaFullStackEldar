package com.javaFullStackEldar.JavaFullStackEldar.model;

import com.javaFullStackEldar.JavaFullStackEldar.dto.BirthdayDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "birthdays")
public class Birthday {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;

    @OneToMany(mappedBy = "birthday", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invitado> invitados;

    public Birthday(){}

    public Birthday(LocalDate fecha) {
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

    public List<Invitado> getInvitados() {
        return invitados;
    }

    public void setInvitados(List<Invitado> invitados) {
        this.invitados = invitados;
    }

    public void addInvitado(Invitado i){
        invitados.add(i);
    }

    public BirthdayDTO toDTO(){
        return new BirthdayDTO(this.id,this.fecha);
    }
}
