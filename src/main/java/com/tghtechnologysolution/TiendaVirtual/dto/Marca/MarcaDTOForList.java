package com.tghtechnologysolution.TiendaVirtual.dto.Marca;

import com.tghtechnologysolution.TiendaVirtual.Models.Marca;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MarcaDTOForList {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private String imagen;
	
	public MarcaDTOForList(Marca mar) {
		this.id =mar.getId();
		this.nombre = mar.getNombre();
		this.descripcion = mar.getDescripcion();
		this.imagen = mar.getImagen();
	}
}
