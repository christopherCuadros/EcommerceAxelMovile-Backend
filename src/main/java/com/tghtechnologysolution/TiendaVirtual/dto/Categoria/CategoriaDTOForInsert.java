package com.tghtechnologysolution.TiendaVirtual.dto.Categoria;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor
public class CategoriaDTOForInsert {
	
	
	// @NotEmpty(message = "El campo no puede estar vacío")
	// @Pattern(regexp = "^[0-9]*$", message = "Solo se permiten números en este campo")
	// private Integer id;
	
	@Size(min = 5, max = 30, message = "La descripcion debe estar entre 5 y 30 caracteres")
	@NotEmpty(message = "El campo no puede estar vacío")
	private String descripcion;
}
