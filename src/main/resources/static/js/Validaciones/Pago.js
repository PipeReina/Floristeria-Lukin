const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');

const expresiones = {
    fechaPago: /^[0-9\/\-]{1,20}$/, // Letras y espacios, pueden llevar acentos.
}

const campos={
    fechaPago:false
}

const validarFormulario = (e) => {
    switch (e.target.name){
        case "fechaPago":
            if(expresiones.fechaPago.test(e.target.value)){
                document.getElementById('grupo_fechaPago').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_fechaPago').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_fechaPago i').classList.add('fa-check-circle');
                document.querySelector('#grupo_fechaPago i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_fechaPago .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['fechaPago'] = true;
            }else{
                document.getElementById('grupo_fechaPago').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_fechaPago').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_fechaPago i').classList.add('fa-times-circle');
                document.querySelector('#grupo_fechaPago i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_fechaPago .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['fechaPago'] = false;
            }
        break;
    }
}


inputs.forEach((input)=>{
    input.addEventListener('keyup', validarFormulario )
    input.addEventListener('blur', validarFormulario )
})


formulario.addEventListener('submit', (e) => {
    if(campos.fechaPago){
        // bien
    }else{
        document.getElementById('formulario__mensaje').classList.add('formulario__mensaje-activo')
    }
});

function guar(){
    alert("Se guardaron los cambios")
  }
  //eliminar
 function eliminar(idPago){
    console.log(idPago);
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
               url:"delete/"+idPago,
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


