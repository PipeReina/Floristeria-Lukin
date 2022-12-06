const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');

const expresiones = {
	costo: /^[0-9\,\.\:\;]{1,100}$/, // numeros, signos de puntuacion (,\.\:\;)
	fecha: /^[a-zA-Z-0-9\,\.\:\;\/\ ]{1,100000}$/, // numeros, signos de puntuacion (,\.\:\;)

}

const campos={
    costo:false,
    fecha:false
}


const validarFormulario = (e) => {
    switch (e.target.name){
        case "CostoVenta":
            if(expresiones.costo.test(e.target.value)){
                document.getElementById('grupo_costo').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_costo').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_costo i').classList.add('fa-check-circle');
                document.querySelector('#grupo_costo i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_costo .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['costo'] = true;
            }else{
                document.getElementById('grupo_costo').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_costo').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_costo i').classList.add('fa-times-circle');
                document.querySelector('#grupo_costo i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_costo .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['costo'] = false;
            }
        break;
        case "FechaCom":
            if(expresiones.fecha.test(e.target.value)){
                document.getElementById('grupo_fecha').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_fecha').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_fecha i').classList.add('fa-check-circle');
                document.querySelector('#grupo_fecha i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_fecha .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['fecha'] = true;
            }else{
                document.getElementById('grupo_fecha').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_fecha').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_fecha i').classList.add('fa-times-circle');
                document.querySelector('#grupo_fecha i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_fecha .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['fecha'] = false;
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
function guar(){
    alert("Se guardaron los cambios")
  }

   //eliminar
   function eliminar(idComision){
    console.log(idComision);
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
               url:"delete/"+idComision,
               success: function(res) {
                  console.log(res);
              },            
            });
          swal("Exito! Campo eliminado correctamente!", {
            icon: "success",
          }).then((ok)=>{
            if(ok){
                location.href="listarcom";
            }
          });
        } else {
          swal("Cancelado!");
        }
      });
  }
  //fin eliminar
