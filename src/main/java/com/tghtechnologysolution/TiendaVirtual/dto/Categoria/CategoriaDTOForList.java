package com.tghtechnologysolution.TiendaVirtual.dto.Categoria;

import com.tghtechnologysolution.TiendaVirtual.Models.Categoria;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoriaDTOForList {
	
	private Integer id;
	private String descripcion;
	
	public CategoriaDTOForList(Categoria cat) {
		this.setId(cat.getId());
		this.setDescripcion(cat.getDescripcion());
	}
	
}
