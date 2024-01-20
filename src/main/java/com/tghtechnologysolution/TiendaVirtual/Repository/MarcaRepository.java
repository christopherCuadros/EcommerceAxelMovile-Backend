package com.tghtechnologysolution.TiendaVirtual.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.tghtechnologysolution.TiendaVirtual.Models.Caracteristica;
import com.tghtechnologysolution.TiendaVirtual.Models.Categoria;
import com.tghtechnologysolution.TiendaVirtual.Models.Marca;

public interface MarcaRepository extends CrudRepository<Marca, Integer>{
	
	// Listar los activos
    @Query("SELECT c FROM Marca c WHERE c.activo=true")
    List<Marca> listar();
    
    // Listar uno por su ID
    @Query("SELECT c FROM Marca c WHERE c.activo=true AND c.id=:mar_id")
    Optional<Marca> listarUno(@Param("mar_id") Integer id);
}
