package com.sprint3.proyecto.Modelos;


import lombok.*;

import javax.persistence.*;
import java.time.*;
import java.time.format.*;

@Entity
@Table(name = "movimientos")
//@Getter
//@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Movimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    private String tipoMovimiento;
    @Column(name = "fecha",length = 255)
    private int fecha;
    private String nombreEmpleadoMovimiento;
    private String empresaEmpleadoMovimiento;

//    @ManyToOne
//    @JoinColumn(name = "empleado_movimientos")
//    private Empleado empleado;
}
