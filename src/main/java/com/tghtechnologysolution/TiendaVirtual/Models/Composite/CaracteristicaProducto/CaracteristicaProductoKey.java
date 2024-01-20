package com.tghtechnologysolution.TiendaVirtual.Models.Composite.CaracteristicaProducto;

import java.io.Serializable;

import com.tghtechnologysolution.TiendaVirtual.Models.Caracteristica;
import com.tghtechnologysolution.TiendaVirtual.Models.Producto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class CaracteristicaProductoKey implements Serializable{
	
	private static final long serialVersionUID = -6175613560297816680L;

	@Column
	private Integer id_producto;
	
	@Column
	private Integer id_caracteristica;
	
	//TODO hashcode and equals
	
	public void setId_producto(Producto prod) {
		id_producto = prod.getId();
	}
	
	public void setId_caracteristica(Caracteristica car) {
		id_caracteristica = car.getId();
	}
	
}
