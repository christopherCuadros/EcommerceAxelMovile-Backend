package com.tghtechnologysolution.TiendaVirtual.dto.Producto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import com.tghtechnologysolution.TiendaVirtual.Models.Caracteristica;
import com.tghtechnologysolution.TiendaVirtual.Models.Categoria;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoDTO {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	
	
	private String sku;
	private String pdf_caracteristicas;
	
	private String img_primaria;
	private String img_secundaria;
	
	private Integer stock;
	private BigDecimal precio_soles;
	
	private LocalDateTime fecha_creacion;
	private LocalDateTime fecha_modificacion;
	private Boolean activo;
	
	private Categoria categoria;
	
	private Set<Caracteristica> caracteristicas;
}
