package com.javaFullStackEldar.JavaFullStackEldar.dto;

public class InvitadoDTO {

    private Long id;
    private Long idPersona;
    private Long idBirthday;

    public InvitadoDTO(Long id, Long idPersona, Long idBirthday) {
        this.id = id;
        this.idPersona = idPersona;
        this.idBirthday = idBirthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Long getIdBirthday() {
        return idBirthday;
    }

    public void setIdBirthday(Long idBirthday) {
        this.idBirthday = idBirthday;
    }
}
