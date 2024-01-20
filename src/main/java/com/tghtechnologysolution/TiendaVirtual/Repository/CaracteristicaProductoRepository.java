package com.tghtechnologysolution.TiendaVirtual.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.tghtechnologysolution.TiendaVirtual.Models.Producto;
import com.tghtechnologysolution.TiendaVirtual.Models.Composite.CaracteristicaProducto.CaracteristicaProducto;

public interface CaracteristicaProductoRepository extends CrudRepository<CaracteristicaProducto, Integer>{

	// Eliminar por producto
	@Transactional
	@Modifying
	@Query("DELETE FROM CaracteristicaProducto cap WHERE cap.producto=:prod")
    void eliminarPorProducto(@Param("prod") Producto prod);
	
	// Seleccionar por producto
	@Query("SELECT cap FROM CaracteristicaProducto cap WHERE cap.producto=:prod")
    List<CaracteristicaProducto> selectPorProducto(@Param("prod") Producto prod);
	
}
