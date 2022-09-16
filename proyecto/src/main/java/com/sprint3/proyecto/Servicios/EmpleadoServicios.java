package com.sprint3.proyecto.Servicios;

import com.sprint3.proyecto.Dto.EmpleadoDto;
import com.sprint3.proyecto.Modelos.Empleado;
import com.sprint3.proyecto.Modelos.Empresa;
import com.sprint3.proyecto.Repositorios.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServicios {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServicios(EmpleadoRepository empleadoRepository) {

        this.empleadoRepository = empleadoRepository;
    }

    public EmpleadoDto save(EmpleadoDto empleado) {
        try {
            Empleado newEmpleado = new Empleado();
            if (empleado.getNombreEmpleado().isEmpty()) {
                return null;
            }
            Empresa empresa = new Empresa();
            empresa.setId(empresa.getId());
            newEmpleado.setNombreEmpresa(empleado.getNombreEmpresa());
            newEmpleado.setNombreEmpleado(empleado.getNombreEmpleado());
            newEmpleado.setCorreoEmpleado(empleado.getCorreoEmpleado());
            newEmpleado.setEmpresaEmpleado(empleado.getEmpresaEmpleado());
            newEmpleado.setRollEmpleado(empleado.getRollEmpleado());
            this.empleadoRepository.save(newEmpleado);
            return empleado;
        }catch (Exception y){
            System.out.println(y);
            return null;
        }
    }


    public List<Empleado> listarEmpleado(){
        return this.empleadoRepository.findAll();
    }


    public Empleado actualizarEmpleado(EmpleadoDto empleado){
        Optional<Empleado> empleadoActualizar = this.empleadoRepository.findById(empleado.getId());
        if(empleadoActualizar.isPresent()){
            empleadoActualizar.get().setNombreEmpresa(empleado.getNombreEmpresa());
            empleadoActualizar.get().setNombreEmpleado(empleado.getNombreEmpleado());
            empleadoActualizar.get().setCorreoEmpleado(empleado.getCorreoEmpleado());
            empleadoActualizar.get().setEmpresaEmpleado(empleado.getEmpresaEmpleado());
            empleadoActualizar.get().setRollEmpleado(empleado.getRollEmpleado());
            this.empleadoRepository.save(empleadoActualizar.get());
            return empleadoActualizar.get();
        }
        return new Empleado();
    }
}
