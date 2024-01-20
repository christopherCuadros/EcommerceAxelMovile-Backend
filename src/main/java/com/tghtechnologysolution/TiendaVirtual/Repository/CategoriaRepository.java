package com.tghtechnologysolution.TiendaVirtual.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tghtechnologysolution.TiendaVirtual.Models.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer>{

	// Listar los activos
    @Query("SELECT c FROM Categoria c WHERE c.activo=true")
    List<Categoria> listar();
    
    // Listar uno por su ID
    @Query("SELECT c FROM Categoria c WHERE c.activo=true AND c.id=:cat_id")
    Optional<Categoria> listarUno(@Param("cat_id") Integer id);
	
}
