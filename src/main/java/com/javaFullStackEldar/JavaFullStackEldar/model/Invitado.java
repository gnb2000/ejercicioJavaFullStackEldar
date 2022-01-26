package com.javaFullStackEldar.JavaFullStackEldar.model;

import com.javaFullStackEldar.JavaFullStackEldar.dto.InvitadoDTO;

import javax.persistence.*;

@Entity
@Table(name = "invitados")
public class Invitado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "birthday_id")
    private Birthday birthday;

    @ManyToOne()
    @JoinColumn(name = "persona_id")
    private Persona persona;

    public Invitado() {}

    public Invitado(Birthday birthday, Persona persona) {
        this.birthday = birthday;
        this.persona = persona;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Birthday getBirthday() {
        return birthday;
    }

    public void setBirthday(Birthday birthday) {
        this.birthday = birthday;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public InvitadoDTO toDTO(){
        return new InvitadoDTO(this.id,this.persona.getIdPersona(),this.birthday.getId());
    }
}
