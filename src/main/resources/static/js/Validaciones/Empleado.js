const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');

const expresiones = {
    nombre: /^[a-zA-Z\s]{1,20}$/, // Letras y espacios, pueden llevar acentos.
    doc: /^\d{7,14}$/, // 7 a 14 numeros.
    tel: /^\d{10}$/, // 7 a 14 numeros.
    direc: /^[a-zA-Z0-9\#\/\-\.\,\s]{1,100}$/, // Letras, numeros, signos de puntuacion (,\.\:\;)
	email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/, //email
    especial: /^[a-zA-Z\s]{1,50}$/, // Letras y espacios, pueden llevar acentos.
    foto:/^[a-zA-Z0-9\_\-\.\,\(\)\/]{1,100000000}$/
}

const campos={
    nombre:false,
    apellido:false,
    documento:false,
    eps:false,
    direcc:false,
    tel:false,
    email:false,
    especial:false,
    foto:false
}

const validarFormulario = (e) => {
    switch (e.target.name){
        case "nombreEmpleado":
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
        case "apellidoEmpleado":
            if(expresiones.nombre.test(e.target.value)){
                document.getElementById('grupo_apellido').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_apellido').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_apellido i').classList.add('fa-check-circle');
                document.querySelector('#grupo_apellido i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_apellido .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['apellido'] = true;
            }else{
                document.getElementById('grupo_apellido').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_apellido').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_apellido i').classList.add('fa-times-circle');
                document.querySelector('#grupo_apellido i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_apellido .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['apellido'] = false;
            }
          break;
          case "docEmpleado":
            if(expresiones.doc.test(e.target.value)){
                document.getElementById('grupo_documento').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_documento').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_documento i').classList.add('fa-check-circle');
                document.querySelector('#grupo_documento i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_documento .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['documento'] = true;
            }else{
                document.getElementById('grupo_documento').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_documento').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_documento i').classList.add('fa-times-circle');
                document.querySelector('#grupo_documento i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_documento .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['documento'] = false;
            }
          break;
          case "epsEmpleado":
            if(expresiones.nombre.test(e.target.value)){
                document.getElementById('grupo_eps').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_eps').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_eps i').classList.add('fa-check-circle');
                document.querySelector('#grupo_eps i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_eps .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['eps'] = true;
            }else{
                document.getElementById('grupo_eps').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_eps').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_eps i').classList.add('fa-times-circle');
                document.querySelector('#grupo_eps i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_eps .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['eps'] = false;
            }
          break;
          case "direccEmpleado":
            if(expresiones.direc.test(e.target.value)){
                document.getElementById('grupo_direcc').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_direcc').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_direcc i').classList.add('fa-check-circle');
                document.querySelector('#grupo_direcc i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_direcc .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['direcc'] = true;
            }else{
                document.getElementById('grupo_direcc').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_direcc').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_direcc i').classList.add('fa-times-circle');
                document.querySelector('#grupo_direcc i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_direcc .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['direcc'] = false;
            }
          break;
          case "telEmpleado":
            if(expresiones.tel.test(e.target.value)){
                document.getElementById('grupo_tel').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_tel').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_tel i').classList.add('fa-check-circle');
                document.querySelector('#grupo_tel i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_tel .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['tel'] = true;
            }else{
                document.getElementById('grupo_tel').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_tel').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_tel i').classList.add('fa-times-circle');
                document.querySelector('#grupo_tel i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_tel .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['tel'] = false;
            }
          break;
          case "emailEmpleado":
            if(expresiones.email.test(e.target.value)){
                document.getElementById('grupo_email').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_email').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_email i').classList.add('fa-check-circle');
                document.querySelector('#grupo_email i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_email .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['email'] = true;
            }else{
                document.getElementById('grupo_email').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_email').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_email i').classList.add('fa-times-circle');
                document.querySelector('#grupo_email i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_email .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['email'] = false;
            }
          break;
          case "especialidadEmpleado":
            if(expresiones.especial.test(e.target.value)){
                document.getElementById('grupo_especial').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_especial').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_especial i').classList.add('fa-check-circle');
                document.querySelector('#grupo_especial i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_especial .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['especial'] = true;
            }else{
                document.getElementById('grupo_especial').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_especial').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_especial i').classList.add('fa-times-circle');
                document.querySelector('#grupo_especial i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_especial .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['especial'] = false;
            }
          break;

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
          case "FotoEmpleado":
            if(expresiones.foto.test(e.target.value)){
                document.getElementById('grupo_foto').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_foto').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_foto i').classList.add('fa-check-circle');
                document.querySelector('#grupo_foto i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_foto .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['foto'] = true;
            }else{
                document.getElementById('grupo_foto').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_foto').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_foto i').classList.add('fa-times-circle');
                document.querySelector('#grupo_foto i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_foto .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['foto'] = false;
            }
          break;
        }
}


inputs.forEach((input)=>{
    input.addEventListener('keyup', validarFormulario )
    input.addEventListener('blur', validarFormulario )
})


function guar(){
    confirm("Se guardaron los cambios");
  }
function eli(){
    confirm("Se Eliminara");
  }

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
 function eliminar(idEmpleado){
    console.log(idEmpleado);
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
               url:"eliminar/"+idEmpleado,
               success: function(res) {
                  console.log(res);
              },      
            });
          swal("Exito! Campo eliminado correctamente!", {
            icon: "success",
          }).then((ok)=>{
            if(ok){
                location.href="empleado";
            }
          });
        } else {
          swal("Cancelado!");
        }
      });
  }
  //fin eliminar

