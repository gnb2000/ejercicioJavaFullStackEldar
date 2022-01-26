import React from 'react';
import ModalButton from '../componentes/ModalButton/ModalButton';
import Modal from '../componentes/Modal/Modal';
import PersonaForm from '../componentes/personaForm/PersonaForm';
import Personas from '../componentes/personas/Personas';

function Home(){

    return (
        <>
            <div className="container text-center mt-3">
                <div className="row">
                    <div className="col-6">
                        <h1>Personas</h1>
                        <ModalButton styles="btn btn-success" modalName="agregarPersonaBtn" title="Agregar persona"/>
                        <Modal modalName="agregarPersonaBtn" title="Agregar persona" component={<PersonaForm/>}/>
                        <Personas/>
                    </div>
                    <div className="col-6">
                        <h1>Invitados</h1>
                        

                    </div>
                </div>
                

            </div>
        </>
    )
}

export default Home;