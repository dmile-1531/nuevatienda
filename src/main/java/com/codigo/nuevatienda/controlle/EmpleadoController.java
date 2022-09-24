package com.codigo.nuevatienda.controlle;
import com.codigo.nuevatienda.model.Empleado;
import com.codigo.nuevatienda.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/empleado/get")
    private List<Empleado> verEmpleado(){
        return empleadoService.verEmpleado();
    }
    @GetMapping("/empleado/get/{id}")
    public Empleado empleado(@PathVariable("id")long id) {
        return this.empleadoService.verEmpleadoId(id);
    }

    @PostMapping("/empleado/post")
    private void crearEmpleado(@RequestBody Empleado empleado){
        empleadoService.crearYActualizarEmpleado(empleado);
    }
    @PatchMapping("/empleado/{id}")
    public Empleado actualizarEmpleado(@PathVariable("id") Long id, @RequestBody Empleado empleado) {
        Empleado empleado1 = empleadoService.verEmpleadoId(id);
        empleado1.setNombreEmpleado(empleado.getNombreEmpleado());
        empleado1.setCorreoEmpleado(empleado.getCorreoEmpleado());
        empleado1.setEmpresaEmpleado(empleado.getEmpresaEmpleado());
        empleado1.setRolEmpleado(empleado.getRolEmpleado());
        return empleadoService.crearYActualizarEmpleado(empleado1);
    }

    @DeleteMapping("/empleado/{id}")
    private void eliminarEmpleado(@PathVariable("id") Long id){
        empleadoService.eliminarEmpleado(id);
    }
}
