package com.tghtechnologysolution.TiendaVirtual.dto.CaracteristicaProducto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CaracteristicaProductoDTOForInsert {
	
	//Integer id; automatico
	
	private Integer id_producto;
	
	private Integer id_caracteristica;
	private String nombre_caracteristica;
	
	private String valor;
	
}
