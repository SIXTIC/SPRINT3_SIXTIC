package com.sprint3.proyecto.Dto;

import com.sprint3.proyecto.Modelos.Empleado;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;
//@Getter
//@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class MovimientosDto {

    private Integer id;
    private String tipoMovimiento;
    @Column(name = "fecha",length = 255)
    private int fecha;
    private String nombreEmpleadoMovimiento;
    private String empresaEmpleadoMovimiento;

}
