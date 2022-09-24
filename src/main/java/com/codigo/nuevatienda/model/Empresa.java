package com.codigo.nuevatienda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;



    private String nombreEmpresa;
    private String direccionEmpresa;
    private int telefonoEmpresa;
    private int nit;

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Empleado> empleados;
}
