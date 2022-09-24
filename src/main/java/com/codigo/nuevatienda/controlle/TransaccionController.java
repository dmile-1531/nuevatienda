package com.codigo.nuevatienda.controlle;

import com.codigo.nuevatienda.model.Transaccion;
import com.codigo.nuevatienda.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransaccionController {

        @Autowired
        TransaccionService transaccionService;

        @GetMapping(value = "/transaccion/get")
        private List<Transaccion> verTransaccion(){
            return transaccionService.verTransaccion();
        }

        @GetMapping("/transaccion/get/{id}")
        public Transaccion transaccion(@PathVariable("id") Long id){
            return this.transaccionService.verTransaccionId(id);
        }

        @PostMapping("/transaccion/post")
        private void crearTransaccion(@RequestBody Transaccion transaccion){
            transaccionService.crearYActualizarTransaccion(transaccion);
        }

        @DeleteMapping("/transaccion/{id}")
        private void eliminarTransaccion(@PathVariable("id") Long id){
            transaccionService.eliminarTransaccion(id);
        }

        @PatchMapping("/transaccion/{id}")
        public Transaccion actualizarTransaccion(@PathVariable("id") Long id, @RequestBody Transaccion transaccion){
            Transaccion transaccion1 = transaccionService.verTransaccionId(id);
            transaccion1.setConcepto (transaccion.getConcepto());
            transaccion1.setMonto(transaccion.getMonto());
            //transaccion1.setFechaActualizacion(transaccion.getFechaActualizacion());
            //transaccion1.setFechaCreate(transaccion.getFechaCreate());
            return transaccionService.crearYActualizarTransaccion(transaccion1);
        }
}

