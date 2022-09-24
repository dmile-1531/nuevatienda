package com.codigo.nuevatienda.service;

import com.codigo.nuevatienda.model.Transaccion;
import com.codigo.nuevatienda.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransaccionService{

    @Autowired
    TransaccionRepository transaccionRepository;

    public Transaccion crearYActualizarTransaccion(Transaccion transaccion){
        Transaccion transaccion1 = transaccionRepository.save(transaccion);
        return transaccion1;
    }

    public List<Transaccion> verTransaccion(){
        List<Transaccion> transaccions = new ArrayList<Transaccion>(transaccionRepository.findAll());
        return transaccions;
    }

    public Transaccion verTransaccionId(Long id){
        return transaccionRepository.findById(id).get();
    }

    public void eliminarTransaccion(Long id){
        transaccionRepository.deleteById(id);
    }

}

