package com.sprint3.proyecto.Servicios;


import com.sprint3.proyecto.Dto.EmpresaDto;
import com.sprint3.proyecto.Modelos.Empresa;
import com.sprint3.proyecto.Repositorios.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServicios {

    private final EmpresaRepository empresaRepository;

    public EmpresaServicios(EmpresaRepository empresaRepository) {

        this.empresaRepository = empresaRepository;
    }

    public EmpresaDto save(EmpresaDto empresa){
        try {
            Empresa newEmpresa = new Empresa();
            if (empresa.getNombreEmpresa().isEmpty()) {
                return null;
            }
            newEmpresa.setNombreEmpresa(empresa.getNombreEmpresa());
            newEmpresa.setDireccionEmpresa(empresa.getDireccionEmpresa());
            newEmpresa.setTelefonoEmpresa(empresa.getTelefonoEmpresa());
            newEmpresa.setNIT(empresa.getNIT());
            this.empresaRepository.save(newEmpresa);
            return empresa;
        }catch (Exception x){
            System.out.println(x);
            return null;
        }
    }

    public List<Empresa> listarEmpresas(){
        return this.empresaRepository.findAll();
    }

    public Empresa actualizarEmpresa(EmpresaDto empresa){
        Optional<Empresa> empresaActualizar = this.empresaRepository.findById(empresa.getId());
        if(empresaActualizar.isPresent()){
            empresaActualizar.get().setNombreEmpresa(empresa.getNombreEmpresa());
            empresaActualizar.get().setTelefonoEmpresa(empresa.getTelefonoEmpresa());
            this.empresaRepository.save(empresaActualizar.get());
            return empresaActualizar.get();
        }
        return new Empresa();
    }
}
