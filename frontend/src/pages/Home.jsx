import React, { useEffect, useState } from 'react';
import ModalButton from '../componentes/ModalButton/ModalButton';
import Modal from '../componentes/Modal/Modal';
import PersonaForm from '../componentes/personaForm/PersonaForm';
import axios from 'axios';

function Home(){

    const [personas,setPersonas] = useState([]);
    const [invitados,setInvitados] = useState([]);
    const [birthday,setBirthday] = useState("");

    useEffect(() => {
        loadPersonas();
    },[])

    useEffect(async () => {
        invitados.map(async invitado => {
            var json = {
                idPersona:invitado.idPersona,
                idBirthday:birthday
            }
           await axios.put("http://localhost:8080/birthdays",json,{headers:{"Content-Type" : "application/json"}});
        })
        setInvitados([]);
        loadPersonas();
    },[birthday])

    function handleDelete(id){
        axios.delete("http://localhost:8080/personas/"+id)
            .then(res => {
                window.location.reload(false);
            })
    }

    function addInvitado(persona){
        setInvitados(invitados => [...invitados, persona]);
        setPersonas(personas.filter(item => item.idPersona !== persona.idPersona));
    }

    function handleInvitar(e){
        const crearBirthday = async () => {
            try {
                const json = {
                    fecha:new Date()
                }
                const birthday = await axios.post("http://localhost:8080/birthdays",json,{headers:{"Content-Type" : "application/json"}});
                setBirthday(birthday.data);
            } catch(err){
                console.error(err);
            }
        }
        crearBirthday();
    }

    
    async function loadPersonas(){
        const personasAPI = await axios.get("http://localhost:8080/personas");
        setPersonas(personasAPI.data);
    }

    return (
        <>
            <div className="container text-center mt-3">
                <div className="row">
                    <div className="col-6">
                        <h1>Personas</h1>
                        <ModalButton styles="btn btn-success" modalName="agregarPersonaBtn" title="Agregar persona"/>
                        <Modal modalName="agregarPersonaBtn" title="Agregar persona" component={<PersonaForm/>}/>
                        <div className="d-flex justify-content-center mt-4">
                            <div class="card">
                                    {personas.length !== 0 ? personas.map(persona => {
                                        return (
                                            <div id={persona.idPersona}>
                                                <ul class="list-group list-group-flush">
                                                    <li class="list-group-item" draggable="true" id={"drag"+persona.idPersona}>{persona.nombre} {persona.apellido} // {persona.fechaNac}
                                                        <br/>
                                                        <a type="button" className="text-warning" href={"persona/"+persona.idPersona}>
                                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
                                                                <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
                                                            </svg>
                                                        </a>
                                                        <a type="button" className="text-danger ms-2" onClick={() => handleDelete(persona.idPersona)}>
                                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
                                                                <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
                                                            </svg>
                                                        </a>
                                                        <br/>
                                                        <a type="button" onClick={() => addInvitado(persona)}>
                                                            <span class="badge bg-success">Agregar a cumplea??os</span>
                                                        </a>
                                                        
                                                    </li>
                                                </ul>
                                            </div>
                                        )
                                    }) : <div class="alert alert-danger" role="alert">No hay personas disponibles para agregar</div> }
                            </div>
                        </div>
                    </div>
                    <div className="col-6">
                        <h1>Invitados</h1>
                        {invitados.length !== 0 ?
                        <>
                            <button type="button" className="btn btn-success mb-2" onClick={() => handleInvitar()}>Invitar</button>
                            <div className="d-flex justify-content-center">    
                                <div class="card">
                                    <ul class="list-group list-group-flush">
                                        {invitados.map(invitado => {
                                            return (
                                                <li class="list-group-item">{invitado.nombre} {invitado.apellido}</li>
                                            )
                                        })}
                                    </ul>
                                </div>
                            </div>
                        </>
                        : <div class="alert alert-danger" role="alert">No hay invitados</div> }
                    </div>
                </div>
            </div>
        </>
    )
}

export default Home;