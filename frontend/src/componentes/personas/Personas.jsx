import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './personas.css';

function Personas(){

    const [personas,setPersonas] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8080/personas")
            .then(res => {
                console.log(res.data);
                setPersonas(res.data);
            })
        
    },[])

    return (
        <div className="d-flex justify-content-center">
            <div class="card">
                <ul class="list-group list-group-flush">
                    {personas.length !== 0 ? personas.map(persona => {
                        return (
                            <li class="list-group-item">{persona.nombre} {persona.apellido} // {persona.fechaNac}</li>
                        )
                    }) : 
                        <div class="alert alert-danger" role="alert">
                            No hay personas disponibles para agregar
                        </div>
                    }
                    
                </ul>
            </div>
        </div>
        
    )
}

export default Personas;