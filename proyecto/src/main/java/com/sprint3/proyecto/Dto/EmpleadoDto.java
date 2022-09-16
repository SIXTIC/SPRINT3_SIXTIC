package com.sprint3.proyecto.Dto;
import com.sprint3.proyecto.Modelos.Movimientos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDto {

    private Integer id;
    private String nombreEmpresa;
    public String nombreEmpleado;
    public String correoEmpleado;
    public String empresaEmpleado;
    public String rollEmpleado;
    private Set<Movimientos> movimientos;

}
