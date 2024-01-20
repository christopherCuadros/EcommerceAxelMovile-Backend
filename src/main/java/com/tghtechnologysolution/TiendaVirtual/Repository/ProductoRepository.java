package com.tghtechnologysolution.TiendaVirtual.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tghtechnologysolution.TiendaVirtual.Models.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer>{

	// Listar los activos
    @Query("SELECT p FROM Producto p WHERE p.activo=true")
    List<Producto> listar();
    
    //Listar uno por su ID
    @Query("SELECT p FROM Producto p WHERE p.activo=true AND p.id=:prod_id")
    Optional<Producto> listarUno(@Param("prod_id") Integer id);
	
}
