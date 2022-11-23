package com.nomina.nomina1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.lang.Integer;

import com.nomina.nomina1.model.Convenio;
import com.nomina.nomina1.model.Empleado;
import com.nomina.nomina1.model.comision;
import com.nomina.nomina1.model.he;
import com.nomina.nomina1.services.EmpleadoServicelmps;
import com.nomina.nomina1.services.NominaServicelmps;


@Controller
@SessionAttributes("nomina")
@RequestMapping("/nomina")
public class NominaController {
    


    @Autowired
    public NominaServicelmps empleadoservicio;
    @Autowired
    public EmpleadoServicelmps Empleado;

     @GetMapping(path={"/nominaTotal","","/"})
     public String NominaTotal(Model mo, @RequestParam (value="IdNom") Integer IdNom){

        Float nomina = 0f;
        Integer diasCon = 0;
        Integer CostoDia = 0;
        Integer SalarioB = 0;
        Integer CostHrs = 0;
        Integer DiasTra = 0;
        Integer AuxTrans = 0;
        Integer CantHrs = 0;
        Float HrsExtra = 0f;
        Boolean TipoHrs;
        Float CostVenta = 0f;
        Float Comision = 0f;
        Float TotalDev=0f;
        Float TotalDed=0f;
        Float Pencion=0f;
        Float Salud=0f;


       if(IdNom!=null){
        Empleado empleado = empleadoservicio.findOne(IdNom);
        for (Convenio nominaempleado:empleado.getConvenio()) {
            //horas trabajadas por dia    
            diasCon=nominaempleado.getHoraConvenio();
            //Costo de las hrs
            CostHrs=nominaempleado.getHoraAlDia(); 
            //dias trabajados 
            DiasTra=nominaempleado.getDiasConvenio();
            //Calculo del dia trabajado
            CostoDia=(diasCon*CostHrs);
            SalarioB=(CostoDia*DiasTra);
            if(SalarioB<2000000){
                AuxTrans=117172;
            }
        

        for (he nominaHrs:empleado.getHrExtraFK()){
            //Cantidad de Hrs
            CantHrs= nominaHrs.getCantidadHrs();
            //otorgar valor boolean
            TipoHrs= nominaHrs.getEstadoHE();
            //Defino SalarioB que tenga datos Flotantes
            Float SalarioBFloat=SalarioB.floatValue();
            if(TipoHrs==false){
                HrsExtra = ((SalarioBFloat*1.25f)/240)*CantHrs;
            }else if(TipoHrs==true){
                HrsExtra = ((SalarioBFloat*1.75f)/240)*CantHrs;
            }
        
        for (comision nominacComision:empleado.getComisionFK()){
            //Costo de la venta 
            CostVenta= nominacComision.getCostoVenta();
            if(CostVenta>80000){
                Comision=CostVenta*0.015f;
            }
        Pencion=(SalarioB+HrsExtra+Comision)*0.04f;
        Salud=Pencion;
    
        TotalDev= SalarioB+AuxTrans+HrsExtra+Comision;

        TotalDed= Pencion+Salud; 

        nomina=TotalDev-TotalDed;
       }

            mo.addAttribute("nomina", nomina);
            mo.addAttribute("SalarioB", SalarioB);
            mo.addAttribute("AuxTrans", AuxTrans);
            mo.addAttribute("HrsExtra", HrsExtra);
            mo.addAttribute("Comision", Comision);
            mo.addAttribute("TotalDev", TotalDev);
            mo.addAttribute("Pencion", Pencion);
            mo.addAttribute("Salud", Salud);
            mo.addAttribute("TotalDed", TotalDed);
            mo.addAttribute("empleado", Empleado.findAll());
            
        }}}

    return "nomina/verNom";
    }
    

    @GetMapping(path={"/nominaTotal1","","/"})
    public String listar(Model m){
        m.addAttribute("empleado", Empleado.findAll());

        return "nomina/verNom1";    
    }

}
