const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');

const expresiones = {
    number: /^[0-9\s]{1,20}$/, // Letras y espacios, pueden llevar acentos.
}

const campos={
    number:false,
}

const validarFormulario = (e) => {
    switch (e.target.name){
        case "horaConvenio":
            if(expresiones.number.test(e.target.value)){
                document.getElementById('grupo_horaConvenio').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_horaConvenio').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_horaConvenio i').classList.add('fa-check-circle');
                document.querySelector('#grupo_horaConvenio i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_horaConvenio .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['nombre'] = true;
            }else{
                document.getElementById('grupo_horaConvenio').classList.add('formulario_grupo-incorrecto');
                document.getElementById('grupo_horaConvenio').classList.remove('formulario_grupo-correcto');
                document.querySelector('#grupo_horaConvenio  i').classList.add('fa-times-circle');
                document.querySelector('#grupo_horaConvenio  i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_horaConvenio  .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['nombre'] = false;
            }
        break;
        case "diasConvenio":
            if(expresiones.number.test(e.target.value)){
                document.getElementById('grupo_diasConvenio').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_diasConvenio').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_diasConvenio i').classList.add('fa-check-circle');
                document.querySelector('#grupo_diasConvenio i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_diasConvenio .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['apellido'] = true;
            }else{
                document.getElementById('grupo_diasConvenio').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_diasConvenio').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_diasConvenio i').classList.add('fa-times-circle');
                document.querySelector('#grupo_diasConvenio i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_diasConvenio .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['apellido'] = false;
            }
          break;
        case "horaAlDia":
            if(expresiones.number.test(e.target.value)){
                document.getElementById('grupo_horaAlDia').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_horaAlDia').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_horaAlDia i').classList.add('fa-check-circle');
                document.querySelector('#grupo_horaAlDia i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_horaAlDia .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['apellido'] = true;
            }else{
                document.getElementById('grupo_horaAlDia').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_horaAlDia').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_horaAlDia i').classList.add('fa-times-circle');
                document.querySelector('#grupo_horaAlDia i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_horaAlDia .formulario__input-error').classList.add('formulario__input-error-activo');
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
            document.getElementById('formulario__mensaje').classList.add('formulario__mensaje-activo')
        }


    });
    
    function guar(){
        alert("Se guardaron los cambios")
      }