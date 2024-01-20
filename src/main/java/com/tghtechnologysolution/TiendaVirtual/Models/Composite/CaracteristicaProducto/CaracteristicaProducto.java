package com.tghtechnologysolution.TiendaVirtual.Models.Composite.CaracteristicaProducto;

import com.tghtechnologysolution.TiendaVirtual.Models.Caracteristica;
import com.tghtechnologysolution.TiendaVirtual.Models.Producto;

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
@Table(name = "CaracteristicaProducto")
public class CaracteristicaProducto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	// Valor de la caracteristica para el producto
	@Column(nullable = false, length = 40)
	private String valor;
	
	// Caracteristica
	@ManyToOne
	@JoinColumn(name = "id_caracteristica", nullable = false)
	private Caracteristica caracteristica;
	
	// Producto
	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false)
	private Producto producto;
	
}
