

//practica para que los documentos esten cargados 
document.addEventListener("DOMContentLoaded",()=>{
    //incluir boton
    const $boton=document.querySelector('#btncrearpdf');
//click del boton 
$boton.addEventListener("click",()=>{
    //captura del documento
    const $elementoaconvertir= document.body;
    //incluir el archivo 
    html2pdf()
    .set({
        margin: 1,
        //nombre del documento que se le sugiere al ususario
        filename:'Reporte.pdf',

        //tipo e imagen y calidad
        image:{
            type:'jpeg',
            quality:0.98
        },
        //opciones para la libreria de canvas
        html2canvas:{
            //entre mayor escala mayor calidad pero pesara mas
            scale:3,
            letterRendering:true,
        },
        jsPDF:{
            unit:"in",
            format:"a3",
            //normal vertical lansdscape en horizontal
            orientation: 'portrait'
        }
    })
    //enviar el elemento para convertir 
    .from($elementoaconvertir)
    //se guarda
    .save()
    //error
    .catch(error=>console.log(error));
});

});