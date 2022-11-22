const abrir=()=>{
    
    document.getElementById('ModalFondo').classList.remove('fondoMol');
    document.getElementById('ModalFondo').classList.add('fondoMol-Activo');

}
const cerrar=()=>{
    
    document.getElementById('ModalFondo').classList.add('divModal');
    document.getElementById('ModalFondo').classList.remove('divModal-activo');

}