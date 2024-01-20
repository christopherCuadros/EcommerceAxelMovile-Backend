package com.tghtechnologysolution.TiendaVirtual.dto.CaracteristicaProducto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CaracteristicaProductoDTO {
	
	private Integer id;
	
	private Integer id_caracteristica;
	private Integer id_producto;
	
	private String valor;
	
}
