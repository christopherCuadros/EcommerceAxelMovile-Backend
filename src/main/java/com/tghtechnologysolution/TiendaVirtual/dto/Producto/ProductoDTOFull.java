package com.tghtechnologysolution.TiendaVirtual.dto.Producto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.tghtechnologysolution.TiendaVirtual.dto.CaracteristicaProducto.CaracteristicaProductoDTOForList;
import com.tghtechnologysolution.TiendaVirtual.dto.Categoria.CategoriaDTOForList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoDTOFull {
	
	// Producto
	private Integer id;
	private String nombre;
	private String descripcion;
	
	private String img_primaria;
	private String img_secundaria;
	
	private Integer stock;
	private BigDecimal precio_soles;
	
	private LocalDateTime fecha_creacion;
	private LocalDateTime fecha_modificacion;
	
	// Categoria
	private CategoriaDTOForList categoria;
	
	// Caracteristicas
	private List<CaracteristicaProductoDTOForList> caracteristicas = new ArrayList<>();
	
}
