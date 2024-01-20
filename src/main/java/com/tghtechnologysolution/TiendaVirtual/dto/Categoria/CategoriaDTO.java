package com.tghtechnologysolution.TiendaVirtual.dto.Categoria;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoriaDTO {
	
	private Integer id;
	private String descripcion;
	private Boolean activo = true;
	
}
