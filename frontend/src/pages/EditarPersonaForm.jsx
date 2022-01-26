import React from 'react';
import { useParams } from 'react-router';
import PersonaForm from '../componentes/personaForm/PersonaForm';

function EditarPersonaForm(){

    let params = useParams();
    
    return(
        <PersonaForm id={params.id}/>
    )
}

export default EditarPersonaForm;