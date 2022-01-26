import React from 'react';
import AgregarPersona from '../componentes/agregarPersona/AgregarPersona';
import Personas from '../componentes/personas/Personas';

function Home(){

    return (
        <>
            <div className="container text-center mt-3">
                <div className="row">
                    <div className="col-6">
                        <h1>Personas</h1>
                        <AgregarPersona/>
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