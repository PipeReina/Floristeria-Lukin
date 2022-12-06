const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');

const expresiones = {
    numer: /^[0-9\,\.\:\;]{1,100}$/, 
	fechahe: /^[a-zA-Z-0-9\,\.\:\;\/\ ]{1,100000}$/,

}

const campos={
    numer:false,
    fechahe:false
}


const validarFormulario = (e) => {
    switch (e.target.name){
        case "FechaHE":
            if(expresiones.fechahe.test(e.target.value)){
                document.getElementById('grupo_fechahe').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_fechahe').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_fechahe i').classList.add('fa-check-circle');
                document.querySelector('#grupo_fechahe i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_fechahe .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['fechahe'] = true;
            }else{
                document.getElementById('grupo_fechahe').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_fechahe').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_fechahe i').classList.add('fa-times-circle');
                document.querySelector('#grupo_fechahe i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_fechahe .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['fechahe'] = false;
            }
        break;
        case "CantidadHrs":
            if(expresiones.fechahe.test(e.target.value)){
                document.getElementById('grupo_CantidadHrs').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_CantidadHrs').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_CantidadHrs i').classList.add('fa-check-circle');
                document.querySelector('#grupo_CantidadHrs i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_CantidadHrs .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['fechahe'] = true;
            }else{
                document.getElementById('grupo_CantidadHrs').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_CantidadHrs').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_CantidadHrs i').classList.add('fa-times-circle');
                document.querySelector('#grupo_CantidadHrs i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_CantidadHrs .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['fechahe'] = false;
            }
        break;
    }
}

inputs.forEach((input)=>{
    input.addEventListener('keyup', validarFormulario )
    input.addEventListener('blur', validarFormulario )
})


formulario.addEventListener('submit', (e) => {
    if(campos.fechahe){
        // bien
    }else{
        document.getElementById('formulario__mensaje').classList.add('formulario__mensaje-activo')
    }
});
function guar(){
    alert("Se guardaron los cambios")
  }
  //eliminar
  function eliminar(idHorasExtra){
    console.log(idHorasExtra);
    swal({
        title: "Esta seguro que desea eliminar?",
        text: "Una vez eliminado no se prodra restablecer!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      })
      .then((OK) => {
        if (OK) {
            $.ajax({
               url:"delete/"+idHorasExtra,
               success: function(res) {
                  console.log(res);
              },            
            });
          swal("Exito! Campo eliminado correctamente!", {
            icon: "success",
          }).then((ok)=>{
            if(ok){
                location.href="listarhe";
            }
          });
        } else {
          swal("Cancelado!");
        }
      });
  }
//fin eliminar
