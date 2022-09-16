package com.sprint3.proyecto.Repositorios;

import com.sprint3.proyecto.Modelos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {


}
