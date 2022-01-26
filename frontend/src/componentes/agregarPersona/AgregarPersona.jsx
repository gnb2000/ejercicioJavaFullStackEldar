import axios from 'axios';
import React, { useState } from 'react';

function AgregarPersona(){

    const [nombre,setNombre] = useState("");
    const [apellido,setApellido] = useState("");
    const [fechaNac,setFechaNac] = useState("");

   
    function handleSubmit(e){
        e.preventDefault();
        var json = {
            nombre:nombre,
            apellido:apellido,
            fechaNac:fechaNac
        }
        axios.post("http://localhost:8080/personas",json,{headers:{"Content-Type" : "application/json"}})
            .then(res => {
                window.location.reload(true);
            })

    }

    return (
        <>
            <button type="button" class="btn btn-success mb-4" data-bs-toggle="modal" data-bs-target="#agregarPersonaBtn">
                Agregar persona
            </button>

            <div class="modal fade" id="agregarPersonaBtn" tabindex="-1" aria-labelledby="agregarPersonaBtnLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="agregarPersonaBtnLabel">Nueva persona</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form onSubmit={handleSubmit}>
                            <div class="modal-body">
                                <div class="mb-3">
                                    <label class="form-label">Nombre</label>
                                    <input type="text" class="form-control" value={nombre} onChange={e => setNombre(e.target.value)} id="nombre" placeholder="Roberto" required/>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Apellido</label>
                                    <input type="text" class="form-control" value={apellido} onChange={e => setApellido(e.target.value)} id="apellido" placeholder="Perez" required/>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Fecha nacimiento</label>
                                    <input type="date" class="form-control" value={fechaNac} onChange={e => setFechaNac(e.target.value)} id="fechaNac" required/>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-warning fw-bold" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-success">Agregar</button>
                            </div>
                        </form>
                            
                    </div>
                </div>
            </div>
        </>
    )
}

export default AgregarPersona;