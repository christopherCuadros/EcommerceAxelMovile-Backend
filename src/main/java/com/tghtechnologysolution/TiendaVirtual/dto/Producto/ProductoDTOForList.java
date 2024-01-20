package com.tghtechnologysolution.TiendaVirtual.dto.Producto;

import java.math.BigDecimal;
import com.tghtechnologysolution.TiendaVirtual.Models.Producto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoDTOForList {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	
	private String img_primaria;
	private String img_secundaria;
	
	private Integer stock;
	private BigDecimal precio_soles;
	
	public ProductoDTOForList(Producto prod) {
		this.id = prod.getId();
		this.nombre = prod.getNombre();
		this.descripcion = prod.getDescripcion();
		this.img_primaria = prod.getImg_primaria();
		this.img_secundaria = prod.getImg_secundaria();
		this.stock = prod.getStock();
		this.precio_soles = prod.getPrecio_soles();
	}
	
}
