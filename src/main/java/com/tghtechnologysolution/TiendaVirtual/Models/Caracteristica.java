package com.tghtechnologysolution.TiendaVirtual.Models;

import java.util.HashSet;
import java.util.Set;

import com.tghtechnologysolution.TiendaVirtual.Models.Composite.CaracteristicaProducto.CaracteristicaProducto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Caracteristica")
public class Caracteristica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private Boolean activo;
	
	// Categoria a la que pertenece
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	//Productos que la poseen
	@OneToMany(mappedBy = "caracteristica")
	private Set<CaracteristicaProducto> productos = new HashSet<>();
	
}
