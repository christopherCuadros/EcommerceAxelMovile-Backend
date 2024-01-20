package com.tghtechnologysolution.TiendaVirtual.dto.Caracteristica;

import com.tghtechnologysolution.TiendaVirtual.Models.Caracteristica;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CaracteristicaDTOForList {
	
	private Integer id;
	private String nombre;
	
	public CaracteristicaDTOForList(Caracteristica car) {
		this.id = car.getId();
		this.nombre = car.getNombre();
	}
	
}
