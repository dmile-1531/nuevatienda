package com.codigo.nuevatienda.service;

import com.codigo.nuevatienda.model.Empleado;
import com.codigo.nuevatienda.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    public Empleado crearYActualizarEmpleado (Empleado empleado){
        Empleado empleado1 = empleadoRepository.save(empleado);
        return empleado1;
    }

    public List<Empleado> verEmpleado(){
        List<Empleado> empleados = new ArrayList<Empleado>();
        empleados.addAll(empleadoRepository.findAll());
        return empleados;
    }

    public void eliminarEmpleado(Long id){
        empleadoRepository.deleteById(id);
    }
    public Empleado verEmpleadoId(Long id) {
        return empleadoRepository.findById(id).get();
    }
}
