package com.sprint3.proyecto.Controllers;

import com.sprint3.proyecto.Dto.EmpresaDto;
import com.sprint3.proyecto.Dto.MovimientosDto;
import com.sprint3.proyecto.Modelos.Empresa;
import com.sprint3.proyecto.Modelos.Movimientos;
import com.sprint3.proyecto.Servicios.MovimientosServicios;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovimientosController {

    private final MovimientosServicios movimientosServicios;

    public MovimientosController(MovimientosServicios movimientosServicios){
        this.movimientosServicios = movimientosServicios;
    }

    @PostMapping("/Movimientos/crear")
    public MovimientosDto crearMovimiento(@RequestBody MovimientosDto movimientos){

        return movimientosServicios.save(movimientos);
    }

    @GetMapping("/Movimientos/listar")
    public ResponseEntity<List<Movimientos>> listarMovimientos(){
        return ResponseEntity.ok().body(this.movimientosServicios.listarMovimientos());
    }

    @PutMapping("/Movimientos/update")
    public ResponseEntity<Movimientos> actualizarMovimientos(@RequestBody MovimientosDto movimientos){
        return  ResponseEntity.ok().body(this.movimientosServicios.actualizarMovimientos(movimientos));
    }
}
