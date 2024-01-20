package com.tghtechnologysolution.TiendaVirtual.dto.Marca;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MarcaDTOForInsert {
	
	@NotEmpty(message = "El campo no puede estar vacío")
	//private Integer id;
	private String imagen;
	
	@NotEmpty(message = "El campo no puede estar vacío")
	@Size(min = 5, max = 20, message = "El nombre debe estar entre 5 y 20 caracteres")
	private String nombre;
	private String descripcion;
}
	
