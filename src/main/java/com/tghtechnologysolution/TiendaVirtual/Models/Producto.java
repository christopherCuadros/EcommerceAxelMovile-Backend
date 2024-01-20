package com.tghtechnologysolution.TiendaVirtual.Models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
@Table(name = "Producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	// Descripcion del producto
	@Column(nullable = false, length = 40)
	private String nombre;
	@Column(nullable = false, length = 800)
	private String descripcion;
	
	// Datros especificos
	@Column(nullable = true, length = 16)
	private String sku; //codigo de referencia
	@Column(nullable = true)
	private String pdf_caracteristicas;
	
	// Imagenes
	@Column(nullable = true)
	private String img_primaria;
	@Column(nullable = true)
	private String img_secundaria;
	
	// Inventario y precio
	@Column(nullable = false)
	private Integer stock;
	@Column(nullable = false)
	private BigDecimal precio_soles;
	
	// Datos de la entidad
	@Column(nullable = false)
	private LocalDateTime fecha_creacion;
	@Column(nullable = false)
	private LocalDateTime fecha_modificacion;
	@Column(nullable = false)
	private Boolean activo;
	
	// Marca
	@ManyToOne
	@JoinColumn(name = "id_marca")
	private Marca marca;
	
	// Categoria
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	// Caracteristicas que puede poseer
	@OneToMany(mappedBy = "producto")
	private Set<CaracteristicaProducto> caracteristicas = new HashSet<>();
	
	//Marca (error de duplicado)
	/*@ManyToOne
	@JoinColumn(name = "id_marca")
	private Marca marca;*/
	
	
	// Tipo de envio
	//@Column(nullable = false)
	//private Integer tipo_envio;
	
}
