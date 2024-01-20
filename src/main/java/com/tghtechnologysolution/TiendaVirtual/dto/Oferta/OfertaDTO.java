package com.tghtechnologysolution.TiendaVirtual.dto.Oferta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.tghtechnologysolution.TiendaVirtual.dto.Producto.ProductoDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OfertaDTO {
	
	private Integer id;

	private Integer porcentaje;
	private BigDecimal nuevo_precio;
	
	private LocalDateTime fecha_inicio;
	private LocalDateTime fecha_finalizacion;
	
	private ProductoDTO producto;
	
	private Boolean activo;
	
	
}
