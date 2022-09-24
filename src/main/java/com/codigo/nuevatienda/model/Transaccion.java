package com.codigo.nuevatienda.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String concepto;
    private double monto;
    //private Date fechaCreate;
    //private Date fechaActualizacion;

   /* @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "empresa_transacion"
            joinColumns = {
                    @JoinColumn(name = "empresa_id", referencedColumnName = "id"
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "transacion_id", referencedColumnName ="id"
                            nullable = false, updatable = false)})
    private Set<Transaccion> tranzaccion();*/

}

