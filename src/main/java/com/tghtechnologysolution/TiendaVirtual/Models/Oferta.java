package com.tghtechnologysolution.TiendaVirtual.Models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Oferta")
public class Oferta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	// Datos de la oferta
	@Column(nullable = false)
	private Integer porcentaje;
	@Column(nullable = false)
	private BigDecimal nuevo_precio;
	@Column(nullable = false)
	private LocalDateTime fecha_inicio;
	@Column(nullable = false)
	private LocalDateTime fecha_finalizacion;
	
	@Column(nullable = false)
	private Boolean activo;
	
	
	// Producto al que pertenece
	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
}
