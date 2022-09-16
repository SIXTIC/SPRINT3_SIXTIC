package com.sprint3.proyecto.Repositorios;

import com.sprint3.proyecto.Modelos.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientosRepository extends JpaRepository<Movimientos, Integer> {


}
