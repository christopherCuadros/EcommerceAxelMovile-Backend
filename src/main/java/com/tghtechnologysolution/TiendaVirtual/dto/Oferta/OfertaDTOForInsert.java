package com.tghtechnologysolution.TiendaVirtual.dto.Oferta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OfertaDTOForInsert {
	
	//Integer id;
	@NotNull(message = "El campo no puede estar vacío")
	private Integer id_producto;
	
	//@NotEmpty(message = "El campo no puede estar vacío")
	private Integer porcentaje;
	private BigDecimal nuevo_precio;
	
	@NotNull(message = "El campo no puede estar vacío")
	private LocalDateTime fecha_inicio;
	private LocalDateTime fecha_finalizacion;
	
	//Boolean activo;
	
	
}
