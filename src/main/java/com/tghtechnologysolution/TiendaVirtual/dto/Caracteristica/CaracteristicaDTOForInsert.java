package com.tghtechnologysolution.TiendaVirtual.dto.Caracteristica;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor
public class CaracteristicaDTOForInsert {
	
	//@NotEmpty(message = "El campo no puede estar vacío")
	//@Pattern(regexp = "^[0-9]*$", message = "Solo se permiten números en este campo")
	//private Integer id;
	
	@Size(min = 5, max = 20, message = "El nombre debe estar entre 5 y 20 caracteres")
	@NotEmpty(message = "El campo no puede estar vacío")
	private String nombre;

	
}
