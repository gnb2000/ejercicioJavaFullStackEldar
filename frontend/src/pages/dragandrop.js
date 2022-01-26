const caja = document.querySelector("#caja");
const contenedor = document.querySelector("#contenedor");


caja.addEventListener('dragstart',e => {
    console.log("Drag start");
})

caja.addEventListener('dragend',e => {
    console.log("Drag end");
})

caja.addEventListener('drag',e => {
    console.log("Drag");
})


contenedor.addEventListener("dragenter", e => {
    console.log("drag enter")
})
