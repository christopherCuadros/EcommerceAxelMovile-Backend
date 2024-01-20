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
@Table(name = "Subpedido")
public class Subpedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	// Datos del pedido
	@Column(nullable = false)
	private Integer cantidad;
	@Column(nullable = false)
	private BigDecimal subtotal;
	@Column(nullable = false)
	private Boolean activo;
	
	
	// Producto pedido
	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
	// Oferta utilizada
	@ManyToOne
	@JoinColumn(name = "id_oferta")
	private Oferta oferta;
	
	
	
}
