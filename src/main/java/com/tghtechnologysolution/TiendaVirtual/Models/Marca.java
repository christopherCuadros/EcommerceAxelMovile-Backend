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
@Table(name = "Marca")
public class Marca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false, length = 20)
	private String nombre;
	@Column(nullable = false, length = 200)
	private String descripcion;
	@Column(nullable = false, length = 150)
	private String imagen;
	@Column(nullable = false)
	private Boolean activo;
	
	// Productos que posee
	@OneToMany(mappedBy = "marca")
	private Set<Producto> productos = new HashSet<>();
	
}
