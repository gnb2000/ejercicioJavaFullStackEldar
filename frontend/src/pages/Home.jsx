import React, { useEffect, useState } from 'react';
import ModalButton from '../componentes/ModalButton/ModalButton';
import Modal from '../componentes/Modal/Modal';
import PersonaForm from '../componentes/personaForm/PersonaForm';
import Personas from '../componentes/personas/Personas';
import Invitados from '../componentes/Invitados/Invitados';

function Home(){
    const [caja,setCaja] = useState("");
    const [contenedor,setContenedor] = useState("");
   

   useEffect(() => {
       console.log("render");
       setCaja(document.getElementById("caja"));
       setContenedor(document.getElementById("contenedor"));

   },[])
   


    function dragOver(e){
        e.preventDefault();
        console.log("DROP");
    }

    function drop(e){
        console.log("drop");
        contenedor.appendChild(caja);

        
    }

 



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

                        
                        {/*<div id="caja" draggable="true"></div>

                        <div id="contenedor" onDragOver={dragOver} onDrop={drop}>
                            <Invitados/>
    </div>*/}
                        <Invitados/>
                        

                    </div>
                </div>
                

            </div>
        </>
    )
}

export default Home;