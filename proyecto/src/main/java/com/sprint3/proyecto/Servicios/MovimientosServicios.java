package com.sprint3.proyecto.Servicios;


import com.sprint3.proyecto.Dto.MovimientosDto;
import com.sprint3.proyecto.Modelos.Empleado;
import com.sprint3.proyecto.Modelos.Empresa;
import com.sprint3.proyecto.Modelos.Movimientos;
import com.sprint3.proyecto.Repositorios.MovimientosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientosServicios {
    private final MovimientosRepository movimientosRepository;

    public MovimientosServicios(MovimientosRepository movimientosRepository){
        this.movimientosRepository = movimientosRepository;
    }

    public MovimientosDto save(MovimientosDto movimientos) {
        try {
            Movimientos newMovimientos = new Movimientos();
            if (movimientos.getTipoMovimiento().isEmpty()){
                return null;
            }
//            Empresa empresa = new Empresa();
//            empresa.setId(empresa.getId());
//            Empleado empleado = new Empleado();
//            empleado.setNombreEmpleado(empleado.getNombreEmpleado());
            newMovimientos.setTipoMovimiento(movimientos.getTipoMovimiento());
            newMovimientos.setFecha(movimientos.getFecha());
            newMovimientos.setNombreEmpleadoMovimiento(movimientos.getNombreEmpleadoMovimiento());
            newMovimientos.setEmpresaEmpleadoMovimiento(movimientos.getEmpresaEmpleadoMovimiento());
            this.movimientosRepository.save(newMovimientos);
            return movimientos;
        }catch (Exception z){
            System.out.println(z);
            return null;
        }
    }

    public List<Movimientos> listarMovimientos(){
        return this.movimientosRepository.findAll();
    }

    public Movimientos actualizarMovimientos(MovimientosDto movimientos){
        Optional<Movimientos> movimientosActualizar = this.movimientosRepository.findById(movimientos.getId());
        if(movimientosActualizar.isPresent()){
            movimientosActualizar.get().setTipoMovimiento(movimientos.getTipoMovimiento());
            movimientosActualizar.get().setFecha(movimientos.getFecha());
            movimientosActualizar.get().setNombreEmpleadoMovimiento(movimientos.getNombreEmpleadoMovimiento());
            movimientosActualizar.get().setEmpresaEmpleadoMovimiento(movimientos.getEmpresaEmpleadoMovimiento());
            this.movimientosRepository.save(movimientosActualizar.get());
            return movimientosActualizar.get();
        }
        return new Movimientos();
    }
}
