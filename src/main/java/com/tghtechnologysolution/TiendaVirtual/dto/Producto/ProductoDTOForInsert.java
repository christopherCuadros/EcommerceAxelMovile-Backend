package com.tghtechnologysolution.TiendaVirtual.dto.Producto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.tghtechnologysolution.TiendaVirtual.dto.CaracteristicaProducto.CaracteristicaProductoDTOForInsert;
import com.tghtechnologysolution.TiendaVirtual.dto.Categoria.CategoriaDTOForList;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor
public class ProductoDTOForInsert {
	
	//id = auto-generado
	@NotEmpty(message = "El campo no puede estar vacío")
	@Size(min = 5, max = 20, message = "El nombre debe estar entre 5 y 20 caracteres")
	private String nombre;
	
	@NotEmpty(message = "El campo no puede estar vacío")
	@Size(min = 5, max = 30, message = "La descripcion debe estar entre 5 y 30 caracteres")
	private String descripcion;
	
	//@NotEmpty(message = "El campo no puede estar vacío")
	private String sku;
	private String pdf_caracteristicas;
	
	@NotNull(message = "El campo no puede estar vacío")
	private Integer stock;
	
	@NotNull(message = "El campo no puede estar vacío")
	private BigDecimal precio_soles;
	
	//fecha_creacion = automatico
	//fecha_modificacion = automatico
	//activo = true;
	
	// Antes de insertar
	private CategoriaDTOForList categoria;
	
	// Despues de insertar
	private Set<CaracteristicaProductoDTOForInsert> caracteristicas = new HashSet<>();
	
}
