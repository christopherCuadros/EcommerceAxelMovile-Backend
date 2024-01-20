package com.tghtechnologysolution.TiendaVirtual.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tghtechnologysolution.TiendaVirtual.Models.Caracteristica;

public interface CaracteristicaRepository extends CrudRepository<Caracteristica, Integer>{

	// Listar los activos
    @Query("SELECT c FROM Caracteristica c WHERE c.activo=true")
    List<Caracteristica> listar();
    
    //Listar uno por su ID
    @Query("SELECT c FROM Caracteristica c WHERE c.activo=true AND c.id=:car_id")
    Optional<Caracteristica> listarUno(@Param("car_id") Integer id);
	
}
