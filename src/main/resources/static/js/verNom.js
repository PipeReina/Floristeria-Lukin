const calcular=()=>{
    var IdNom=document.getElementById('IdNom').value;
    location.href = 'http://localhost:8090/nomina/nominaTotal?IdNom='+IdNom;
}