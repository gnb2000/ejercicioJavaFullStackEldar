import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate } from "react-router-dom";

function PersonaForm(props){

    const [nombre,setNombre] = useState("");
    const [apellido,setApellido] = useState("");
    const [fechaNac,setFechaNac] = useState("");
    let navigate = useNavigate();
    
    useEffect(() => {
        if (props.id !== undefined){
            axios.get("http://localhost:8080/personas/"+props.id)
                .then(res => {
                    setNombre(res.data.nombre);
                    setApellido(res.data.apellido);
                    setFechaNac(res.data.fechaNac);
                })
        }
    },[])

    function handleSubmit(e){
        e.preventDefault();
        if (props.id !== undefined){
            var json = {
                idPersona:props.id,
                nombre:nombre,
                apellido:apellido,
                fechaNac:fechaNac
            }
            axios.put("http://localhost:8080/personas",json,{headers:{"Content-Type" : "application/json"}})
                .then(res => {
                    navigate("/home");
                })
        } else {
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
        
    }

    return (
        <div className="container mt-4">
            <form onSubmit={handleSubmit}>
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
                <div className="d-flex justify-content-center">
                    <button type="submit" class="btn btn-success ">{props.id !== undefined ? <span>Actualizar</span> : <span>Agregar</span>}</button>
                </div>
            </form>   
        </div>
                
    )
}

export default PersonaForm;