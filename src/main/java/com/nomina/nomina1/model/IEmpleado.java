package com.nomina.nomina1.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface IEmpleado extends CrudRepository<Empleado,Integer>{
    public Optional <Empleado> findByEmailEmpleado(String emailEmpleado);
    public Optional <Empleado> findByDocEmpleado(String docEmpleado);
    public Optional <Empleado> findByTelEmpleado(String telEmpleado );
    
//      @Query ("SELECT 
//      empleado.id_empleado,
//      empleado.nombre_empleado,
//      empleado.apellido_empleado,
//      convenio.salario_convenio,
//      convenio.dias_convenio,
//      (convenio.salario_convenio<2000000)*117172 as AuxTrans,
//      (((convenio.salario_convenio*(hse.estadohe=0))*1.25)+((convenio.salario_convenio*(hse.estadohe=1))*1.75))/240 as TotalHorasExtras,
//      ((comisiones.costo_venta>80000)*comisiones.costo_venta)*0.015 as TotalComision,
//      (convenio.salario_convenio+((convenio.salario_convenio<2000000)*117172)+
//       (((comisiones.costo_venta>80000)*comisiones.costo_venta)*0.015)+
//       ((((convenio.salario_convenio*(hse.estadohe=0))*1.25)+((convenio.salario_convenio*(hse.estadohe=1))*1.75))/240)) as TotalDevengado,
//       (convenio.salario_convenio+(((comisiones.costo_venta>80000)*comisiones.costo_venta)*0.015)+
//       ((((convenio.salario_convenio*(hse.estadohe=0))*1.25)+((convenio.salario_convenio*(hse.estadohe=1))*1.75))/240))*0.08 as TotalDeducido,
//       pago.id_pago,
//       ((convenio.salario_convenio+((convenio.salario_convenio<2000000)*117172)+
//       (((comisiones.costo_venta>80000)*comisiones.costo_venta)*0.015)+
//       ((((convenio.salario_convenio*(hse.estadohe=0))*1.25)+((convenio.salario_convenio*(hse.estadohe=1))*1.75))/240)))-( (convenio.salario_convenio+(((comisiones.costo_venta>80000)*comisiones.costo_venta)*0.015)+
//       ((((convenio.salario_convenio*(hse.estadohe=0))*1.25)+((convenio.salario_convenio*(hse.estadohe=1))*1.75))/240))*0.08) as TotalPago
//       FROM devengado INNER JOIN empleado on empleado.id_empleado=devengado.fkempleado_id_empleado LEFT JOIN cargo on cargo.id_cargo = empleado.id_empleado LEFT JOIN convenio on convenio.fkempleado_id_empleado=empleado.id_empleado LEFT JOIN comisiones on comisiones.id_empleadofk_id_empleado = empleado.id_empleado LEFT JOIN hse on hse.id_empleadofk_id_empleado=empleado.id_empleado LEFT JOIN incapacidad on incapacidad.fkempleado_id_empleado = empleado.id_empleado LEFT JOIN pago on pago.fkdevengado_id = devengado.id_dev;");
}
    
