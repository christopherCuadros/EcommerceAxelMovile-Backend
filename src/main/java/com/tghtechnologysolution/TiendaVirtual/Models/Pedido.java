package com.tghtechnologysolution.TiendaVirtual.Models;

import java.math.BigDecimal;

import com.tghtechnologysolution.TiendaVirtual.Models.Enum.EstadoPedido;

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
@Table(name = "Pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	// Datos del pedido
	@Column(nullable = false)
	private BigDecimal total;
	
	
	@Column(nullable = false)
	private Boolean activo;
	
	@Column(nullable = false)
	EstadoPedido estado;
	
	// Producto pedido
	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
	// Oferta utilizada
	@ManyToOne
	@JoinColumn(name = "id_oferta")
	private Oferta oferta;
	
	
	
}
