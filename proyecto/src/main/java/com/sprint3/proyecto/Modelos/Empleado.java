package com.sprint3.proyecto.Modelos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "empleado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nombreEmpresa")
    private String nombreEmpresa;

    public String nombreEmpleado;
    public String correoEmpleado;
    public String empresaEmpleado;
    public String rollEmpleado;

//    @OneToMany(mappedBy = "empleado")
//    private Set<Movimientos> movimientos;

}
