package com.tghtechnologysolution.TiendaVirtual.dto.Marca;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MarcaDTO {
	
	private Integer Id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private Boolean activo;
}
