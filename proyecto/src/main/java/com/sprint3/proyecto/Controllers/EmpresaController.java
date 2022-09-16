package com.sprint3.proyecto.Controllers;


import com.sprint3.proyecto.Dto.EmpresaDto;
import com.sprint3.proyecto.Modelos.Empresa;
import com.sprint3.proyecto.Servicios.EmpresaServicios;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaController {

    private final EmpresaServicios empresaServicios;

    public EmpresaController(EmpresaServicios empresaServicios) {

        this.empresaServicios = empresaServicios;
    }

    @PostMapping("/Empresa/crear")
    public EmpresaDto crearEmpresa(@RequestBody EmpresaDto empresa){

        return empresaServicios.save(empresa);
    }

    @GetMapping("/Empresa/listar")
    public ResponseEntity<List<Empresa>> listarEmpresas(){
        return ResponseEntity.ok().body(this.empresaServicios.listarEmpresas());
    }

    @PutMapping("/Empresa/update")
    public ResponseEntity<Empresa> actualizarEmpresa(@RequestBody EmpresaDto empresa){
        return  ResponseEntity.ok().body(this.empresaServicios.actualizarEmpresa(empresa));
    }

}
