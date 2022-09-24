package com.codigo.nuevatienda.controlle;

import com.codigo.nuevatienda.model.Empresa;
import com.codigo.nuevatienda.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping("/empresa/get")
    private List<Empresa> verEmpresa(){
        return empresaService.verEmpresa();
    }
    @GetMapping("/empresa/get/{id}")
    public Empresa empresa(@PathVariable("id") Long id){
        return  this.empresaService.verEmpresaId(id);
    }

    @PostMapping("/empresa/post")
    private void crearEmpleado(@RequestBody Empresa empresa){
        empresaService.crearYActualizarEmpresa(empresa);
    }
    @PatchMapping("/empresa/{id}")
    public Empresa actualizarEmpresa(@PathVariable("id") Long id, @RequestBody Empresa empresa) {
        Empresa empresa1 = empresaService.verEmpresaId(id);
        empresa1.setNombreEmpresa(empresa.getNombreEmpresa());
        empresa1.setDireccionEmpresa(empresa.getDireccionEmpresa());
        empresa1.setTelefonoEmpresa(empresa.getTelefonoEmpresa());
        empresa1.setNit(empresa.getNit());
        return empresaService.crearYActualizarEmpresa(empresa1);
    }
    @DeleteMapping("/empresa/{id}")
    private void eliminarEmpresa(@PathVariable("id") Long id){
        empresaService.eliminarEmpresa(id);
    }

}
