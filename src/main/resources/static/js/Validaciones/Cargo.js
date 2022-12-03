const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');

const expresiones = {
    nombre: /^[a-zA-Z\s]{1,20}$/, // Letras y espacios, pueden llevar acentos.
	descrip: /^[a-zA-Z\,\.\:\;]{1,100}$/, // Letras, numeros, signos de puntuacion (,\.\:\;)
}

const campos={
    nombre:false,
    descrip:false
}

const validarFormulario = (e) => {
    switch (e.target.name){
        case "NombreCargo":
            if(expresiones.nombre.test(e.target.value)){
                document.getElementById('grupo_nombre').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_nombre').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_nombre i').classList.add('fa-check-circle');
                document.querySelector('#grupo_nombre i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_nombre .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['nombre'] = true;
            }else{
                document.getElementById('grupo_nombre').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_nombre').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_nombre i').classList.add('fa-times-circle');
                document.querySelector('#grupo_nombre i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_nombre .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['nombre'] = false;
            }
        break;
        case "DescripcionCargo":
            if(expresiones.descrip.test(e.target.value)){
                document.getElementById('grupo_descrip').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_descrip').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_descrip i').classList.add('fa-check-circle');
                document.querySelector('#grupo_descrip i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_descrip .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['descrip'] = true;
            }else{
                document.getElementById('grupo_descrip').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_descrip').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_descrip i').classList.add('fa-times-circle');
                document.querySelector('#grupo_descrip i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_descrip .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['descrip'] = false;
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
        document.getElementById('formulario__mensaje').classList.add('formulario__mensaje-activo')
    }
});

//eliminar
function eliminar(idCargo){
    console.log(idCargo);
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
               url:"eliminar/"+idCargo,
               success: function(res) {
                  console.log(res);
              },			
            });
          swal("Exito! Campo eliminado correctamente!", {
            icon: "success",
          }).then((ok)=>{
            if(ok){
                location.href="cargo";
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