package com.tghtechnologysolution.TiendaVirtual.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tghtechnologysolution.TiendaVirtual.Models.Oferta;

public interface OfertaRepository extends CrudRepository<Oferta, Integer>{

	// Listar los activos
    @Query("SELECT o FROM Oferta o WHERE o.activo=true")
    List<Oferta> listar();
    
    // Listar uno por su ID
    @Query("SELECT o FROM Oferta o WHERE o.activo=true AND o.id=:ofer_id")
    Optional<Oferta> listarUno(@Param("ofer_id") Integer id);
	
}
