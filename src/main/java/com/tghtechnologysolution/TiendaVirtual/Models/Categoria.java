package com.tghtechnologysolution.TiendaVirtual.Models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String descripcion;
	@Column(nullable = false)
	private Boolean activo;
	
	//Caracteristicas que puede poseer
	@OneToMany(mappedBy = "categoria")
	private Set<Caracteristica> caracteristicas = new HashSet<>();
	
	//Productos que puede poseer
	@OneToMany(mappedBy = "categoria")
	private Set<Producto> productos = new HashSet<>();
	
}
