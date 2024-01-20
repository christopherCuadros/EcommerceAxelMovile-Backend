package com.tghtechnologysolution.TiendaVirtual.dto.Oferta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OfertaDTONoProducto {

	private Integer id;
	
	private Integer porcentaje;
	private BigDecimal nuevo_precio;
	
	private LocalDateTime fecha_inicio;
	private LocalDateTime fecha_finalizacion;
	
}
