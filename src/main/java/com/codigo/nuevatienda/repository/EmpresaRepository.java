package com.codigo.nuevatienda.repository;

import com.codigo.nuevatienda.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository <Empresa, Long> {
}