package com.codigo.nuevatienda.service;

import com.codigo.nuevatienda.model.Empresa;
import com.codigo.nuevatienda.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;

    public Empresa crearYActualizarEmpresa(Empresa empresa){
        Empresa empresa1 = empresaRepository.save(empresa);
        return empresa1;
    }

    public List<Empresa> verEmpresa() {
        List<Empresa> empresas = new ArrayList<Empresa>();
        empresas.addAll(empresaRepository.findAll());
        return empresas;
    }

    public void eliminarEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }

    public Empresa verEmpresaId(Long id){
        return empresaRepository.findById(id).get();
    }
}
