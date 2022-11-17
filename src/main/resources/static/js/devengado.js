const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');

const expresiones = {
    totalDev: /^[0-9]{1,100}$/, // Letras y espacios, pueden llevar acentos.
	fechaDev: /^[0-9\/\s\-]{1,50}$/, // Letras, numeros, signos de puntuacion (,\.\:\;)
}

const campos={
    totalDev:false,
    fechaDev:false
}

const validarFormulario = (e) => {
    switch (e.target.name){
        case "totalDev":
            if(expresiones.totalDev.test(e.target.value)){
                document.getElementById('grupo_totalDev').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_totalDev').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_totalDev i').classList.add('fa-check-circle');
                document.querySelector('#grupo_totalDev i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_totalDev .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['totalDev'] = true;
            }else{
                document.getElementById('grupo_totalDev').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_totalDev').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_totalDev i').classList.add('fa-times-circle');
                document.querySelector('#grupo_totalDev i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_totalDev .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['totalDev'] = false;

            }
        break;
        case "fechaDev":
            if(expresiones.fechaDev.test(e.target.value)){
                document.getElementById('grupo_fechaDev').classList.remove('formulario_grupo-incorrecto');
                document.getElementById('grupo_fechaDev').classList.add('formulario_grupo-correcto');
                document.querySelector('#grupo_fechaDev i').classList.add('fa-check-circle');
                document.querySelector('#grupo_fechaDev i').classList.remove('fa-times-circle');
                document.querySelector('#grupo_fechaDev .formulario__input-error').classList.remove('formulario__input-error-activo');
                campos['fechaDev'] = true;
            }else{
                document.getElementById('grupo_fechaDev').classList.add('formulario_grupo-incorrecto')
                document.getElementById('grupo_fechaDev').classList.remove('formulario_grupo-correcto')
                document.querySelector('#grupo_fechaDev i').classList.add('fa-times-circle');
                document.querySelector('#grupo_fechaDev i').classList.remove('fa-check-circle');
                document.querySelector('#grupo_fechaDev .formulario__input-error').classList.add('formulario__input-error-activo');
                campos['fechaDev'] = false;
            }
        break;
    }
}


inputs.forEach((input)=>{
    input.addEventListener('keyup', validarFormulario )
    input.addEventListener('blur', validarFormulario )
})


// formulario.addEventListener('submit', (e) => {
//     if(campos.totalDev && campos.fechaDev){
//         // bien
//     }else{
//         document.getElementById('formulario__mensaje').classList.add('formulario__mensaje-activo')
//     }
// });

