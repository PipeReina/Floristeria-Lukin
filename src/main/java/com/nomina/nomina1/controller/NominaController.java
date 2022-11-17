package com.nomina.nomina1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.nomina.nomina1.model.Pago;
import com.nomina.nomina1.model.comision;
import com.nomina.nomina1.model.Empleado;
import com.nomina.nomina1.model.Cargo;
import com.nomina.nomina1.model.Convenio;
import com.nomina.nomina1.model.he;
import com.nomina.nomina1.model.comision;
import com.nomina.nomina1.model.Cargo;



public class NominaController {
    
    @Autowired
    private Pago Pagof;
    @Autowired
    private Empleado Empleadof;
    @Autowired
    private Convenio Conveniof;
    @Autowired
    private he hsef;
    @Autowired
    private comision ComiIcomisionf;
    @Autowired
    private Cargo Cargof;

    private Integer Convenioo=Conveniof.getDiasConvenio();
    private String EmpleadoNombre=Empleadof.getApellidoEmpleado();
    private String EmpleadoApellido=Empleadof.getNombreEmpleado();
    private Integer Comisioon=ComiIcomisionf.getCostoVenta();
    // private Integer hse=hsef.getFechaHE();
    private String Cargoo=Cargof.getNombreCargo();
    // private Integer Pagoo=Pagof.getFechaPago();

    @GetMapping(path={"/nominaTotal","","/"})
    public String NominaTotal(Model mo){
        
////////////////////////////////////////////calcular contrato 

        Integer Contrato= (Convenioo*60000);

//////////////////////////////////////////// Calcular AuxTrans

        if(Contrato>2000000){
            Integer AuxTrans = 0;
        }else{
            Integer AuxTrans = 117172;
        }

/////////////////////////////////////////// Condicion Comisión 
        if(Comisioon>=80000){
            Integer totalComision = Comisioon;
        }else {
            Integer totalComision = 0;
        }
        
        return "nomina/verNom";
    }

    /*public String listar(Model m){
        m.addAttribute("Pagos", Contrato.findAll());
        m.addAttribute("Devengados", Devengadof.findAll());
        return "Pago/listar";    
    }*/
}
