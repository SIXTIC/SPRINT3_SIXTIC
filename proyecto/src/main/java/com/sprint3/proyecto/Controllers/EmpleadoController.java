package com.sprint3.proyecto.Controllers;


import com.sprint3.proyecto.Dto.EmpleadoDto;
import com.sprint3.proyecto.Modelos.Empleado;
import com.sprint3.proyecto.Servicios.EmpleadoServicios;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmpleadoController {

    private final EmpleadoServicios empleadoServicios;

    public EmpleadoController(EmpleadoServicios empleadoServicios){

        this.empleadoServicios =empleadoServicios;
    }

    @PostMapping("/Empleado/crear")
    public EmpleadoDto crearEmpleado(@RequestBody EmpleadoDto empleado){

        return empleadoServicios.save(empleado);
    }

    @GetMapping("/Empleado/listar")
    public ResponseEntity<List<Empleado>> listarEmpleado(){
        return ResponseEntity.ok().body(this.empleadoServicios.listarEmpleado());
    }

    @PutMapping("/Empleado/update")
    public ResponseEntity<Empleado> actualizarEmpleado(@RequestBody EmpleadoDto empleado){
        return  ResponseEntity.ok().body(this.empleadoServicios.actualizarEmpleado(empleado));
    }


}
