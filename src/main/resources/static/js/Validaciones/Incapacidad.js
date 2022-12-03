
const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');
let fecha = document.getElementById('fechaInicio');
let fechaFin = document.getElementById('fechaFinal');

fecha.addEventListener("change", function() {
    let input = this.value;
    let dateEntered = new Date(input);
    let fechaDefinitiva = dateEntered.getFullYear()+"-"+(dateEntered.getMonth()+1)+"-"+(dateEntered.getDate()+4)
    fechaFin.min = input; 
    fechaFin.max = fechaDefinitiva; 
});

const expresiones = {
    fecha: /^[0-9\/\-\s]{1,100}$/ // Letras, numeros, signos de puntuacion (,\.\:\;)

}

const campos={
  soporte:false,
  fecha:false,
}

const validarFormulario = (e) => {
    switch (e.target.name){
        case "fechaInicio":
            if(expresiones.fecha.test(e.target.value)){
                document.getElementById('grupo_fechaInicio').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_fechaInicio').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_fechaInicio i').classList.add('fa-check-circle');
                document.querySelector('#grupo_fechaInicio i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_fechaInicio .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['nombre'] = true;
            }else{
                document.getElementById('grupo_fechaInicio').classList.add('formulario_grupo-incorrecto');
                document.getElementById('grupo_fechaInicio').classList.remove('formulario_grupo-correcto');
                document.querySelector('#grupo_fechaInicio  i').classList.add('fa-times-circle');
                document.querySelector('#grupo_fechaInicio  i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_fechaInicio  .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['nombre'] = false;
            }
        break;
        case "fechaFinal":
            if(expresiones.fecha.test(e.target.value)){
                document.getElementById('grupo_fechaFinal').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_fechaFinal').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_fechaFinal i').classList.add('fa-check-circle');
                document.querySelector('#grupo_fechaFinal i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_fechaFinal .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['apellido'] = true;
            }else{
                document.getElementById('grupo_fechaFinal').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_fechaFinal').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_fechaFinal i').classList.add('fa-times-circle');
                document.querySelector('#grupo_fechaFinal i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_fechaFinal .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['apellido'] = false;
            }
          break;
        case "soporteIncapacidad":
            if(expresiones.soporte.test(e.target.value)){
                document.getElementById('grupo_soporteIncapacidad').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_soporteIncapacidad').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_soporteIncapacidad i').classList.add('fa-check-circle');
                document.querySelector('#grupo_soporteIncapacidad i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_soporteIncapacidad .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['apellido'] = true;
            }else{
                document.getElementById('grupo_soporteIncapacidad').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_soporteIncapacidad').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_soporteIncapacidad i').classList.add('fa-times-circle');
                document.querySelector('#grupo_soporteIncapacidad i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_soporteIncapacidad .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['apellido'] = false;
            }
          break;
         
        }
    }
    inputs.forEach((input)=>{
        input.addEventListener('keyup', validarFormulario )
        input.addEventListener('blur', validarFormulario )
    })
    
    
    formulario.addEventListener('submit', (e) => {
        if(campos.nombre && campos.descrip){
            // bien
        }else{
        }

    });
    //eliminar
  function eliminar(idIncapacidad){
    console.log(idIncapacidad);
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
               url:"delete/"+idIncapacidad,
               success: function(res) {
                  console.log(res);
              },			
            });
          swal("Exito! Campo eliminado correctamente!", {
            icon: "success",
          }).then((ok)=>{
            if(ok){
                location.href="listar";
            }
          });
        } else {
          swal("Cancelado!");
        }
      });
  }
  //fin eliminar

    function guar(){
        alert("Se guardaron los cambios")
      }
    