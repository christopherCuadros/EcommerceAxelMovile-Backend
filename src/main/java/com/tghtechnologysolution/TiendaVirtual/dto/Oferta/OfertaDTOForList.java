package com.tghtechnologysolution.TiendaVirtual.dto.Oferta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.tghtechnologysolution.TiendaVirtual.Models.Oferta;
import com.tghtechnologysolution.TiendaVirtual.dto.Producto.ProductoDTOForList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OfertaDTOForList {
	
	private Integer id;

	private Integer porcentaje;
	private BigDecimal nuevo_precio;
	
	private LocalDateTime fecha_inicio;
	private LocalDateTime fecha_finalizacion;
	
	//Boolean activo;
	
	private ProductoDTOForList producto;
	
	public OfertaDTOForList(Oferta ofer) {
		this.id = ofer.getId();
		this.porcentaje = ofer.getPorcentaje();
		this.nuevo_precio = ofer.getNuevo_precio();
		this.fecha_inicio = ofer.getFecha_inicio();
		this.fecha_finalizacion = ofer.getFecha_finalizacion();
		
		this.producto = new ProductoDTOForList(ofer.getProducto());
		
	}
	
}
