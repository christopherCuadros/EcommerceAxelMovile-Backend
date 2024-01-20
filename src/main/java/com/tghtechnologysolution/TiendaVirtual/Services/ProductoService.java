package com.tghtechnologysolution.TiendaVirtual.Services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tghtechnologysolution.TiendaVirtual.Models.Caracteristica;
import com.tghtechnologysolution.TiendaVirtual.Models.Categoria;
import com.tghtechnologysolution.TiendaVirtual.Models.Producto;
import com.tghtechnologysolution.TiendaVirtual.Models.Composite.CaracteristicaProducto.CaracteristicaProducto;
import com.tghtechnologysolution.TiendaVirtual.Repository.CaracteristicaProductoRepository;
import com.tghtechnologysolution.TiendaVirtual.Repository.CaracteristicaRepository;
import com.tghtechnologysolution.TiendaVirtual.Repository.CategoriaRepository;
import com.tghtechnologysolution.TiendaVirtual.Repository.ProductoRepository;
import com.tghtechnologysolution.TiendaVirtual.Util.IdNotFoundException;
import com.tghtechnologysolution.TiendaVirtual.dto.CaracteristicaProducto.CaracteristicaProductoDTOForInsert;
import com.tghtechnologysolution.TiendaVirtual.dto.CaracteristicaProducto.CaracteristicaProductoDTOForList;
import com.tghtechnologysolution.TiendaVirtual.dto.Categoria.CategoriaDTOForList;
import com.tghtechnologysolution.TiendaVirtual.dto.Marca.MarcaDTOForList;
import com.tghtechnologysolution.TiendaVirtual.dto.Producto.ProductoDTOForInsert;
import com.tghtechnologysolution.TiendaVirtual.dto.Producto.ProductoDTOForList;
import com.tghtechnologysolution.TiendaVirtual.dto.Producto.ProductoDTOFull;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoService {
	
	@Autowired
	private ProductoRepository prodRepo;
	private CategoriaRepository catRepo;
	private CaracteristicaRepository carRepo;
	private CaracteristicaProductoRepository carprodRepo;
	
	//Crear
	public ProductoDTOForList crearProducto(ProductoDTOForInsert iProd) {
		
		boolean estado = true;
		
		// Obtener id de la categoria a insertar
		Integer id_categoria = iProd.getCategoria().getId();
		Categoria cat = new Categoria();
		
		// Crear categoría si no existe
		if(id_categoria == null) {
			
			// Crear nueva categoria
			cat.setDescripcion(iProd.getCategoria().getDescripcion());
			cat.setActivo(true);
			// Obtener la instancia de la categoria creada
			cat = catRepo.save(cat);
		} else {
			// Validar que la id sea correcta
			
			// Buscar la categoria por su id
			cat = catRepo.findById(id_categoria).get();
		}
		
		// Crear nuevo producto
		Producto prod = new Producto();
		prod.setNombre(iProd.getNombre());
		prod.setDescripcion(iProd.getDescripcion());
		prod.setSku(iProd.getSku());
		prod.setPdf_caracteristicas(iProd.getPdf_caracteristicas());
		prod.setImg_primaria(""); //TODO: imagen
		prod.setImg_secundaria(""); //TODO: imagen
		prod.setStock(iProd.getStock());
		prod.setPrecio_soles(iProd.getPrecio_soles());
		
		prod.setFecha_creacion(LocalDateTime.now());
		prod.setFecha_modificacion(LocalDateTime.now());
		prod.setActivo(true);
		
		// Asignar categoria
		prod.setCategoria(cat);
		cat.getProductos().add(prod);
		
		// Guardar producto
		prod = prodRepo.save(prod);
		
		
		// Crear características TODO: validar que las caracteristicas se puedan insertar correctamente
		if(iProd.getCaracteristicas() != null) {
			carprodRepo.saveAll(insertarCaracteristicas(prod, iProd.getCaracteristicas()));
		}
		//return estado;
		return new ProductoDTOForList(prod);
	}
	
	//Listar
	public List<ProductoDTOForList> listarProductos(){
		List<ProductoDTOForList> prodList = new ArrayList<>();
		List<Producto> prods = (List<Producto>) prodRepo.listar();
		
		/*for(Producto prod : prods) {
			ProductoDTOForList p = new ProductoDTOForList();
			p.setId(prod.getId());
			p.setNombre(prod.getNombre());
			p.setDescripcion(prod.getDescripcion());
			p.setImg_primaria(prod.getImg_primaria());
			p.setImg_secundaria(prod.getImg_secundaria());
			p.setStock(prod.getStock());
			p.setPrecio_soles(prod.getPrecio_soles());
			prodList.add(p);
		}*/
		
		//For -> ForEach
		prods.forEach(prod -> {
			prodList.add(new ProductoDTOForList(prod));
		});
		
		return prodList;
	}
	
	//Listar Uno
	public ProductoDTOFull listarProducto(int id){
		final ProductoDTOFull p = new ProductoDTOFull();
		Optional<Producto> oprod = prodRepo.listarUno(id);
		if(oprod.isPresent()) {
			Producto prod = buscarPorId(id);
			p.setId(prod.getId());
			p.setNombre(prod.getNombre());
			p.setDescripcion(prod.getDescripcion());
			p.setImg_primaria(prod.getImg_primaria());
			p.setImg_secundaria(prod.getImg_secundaria());
			p.setStock(prod.getStock());
			p.setPrecio_soles(prod.getPrecio_soles());
			
			p.setFecha_creacion(prod.getFecha_creacion());
			p.setFecha_modificacion(prod.getFecha_modificacion());
			
			CategoriaDTOForList c = new CategoriaDTOForList();
			Categoria cat = prod.getCategoria();
			c.setId(cat.getId());
			c.setDescripcion(cat.getDescripcion());
			p.setCategoria(c);
			
			prod.getCaracteristicas().forEach(car ->{
				CaracteristicaProductoDTOForList cc = new CaracteristicaProductoDTOForList();
				cc.setNombre_caracteristica(car.getCaracteristica().getNombre());
				cc.setValor(car.getValor());
				p.getCaracteristicas().add(cc);
			});
		}
		return p;
	}
	
	//Modificar
	public void modificarProducto(Integer id, ProductoDTOForInsert prodm) {
		Optional<Producto> oprod = prodRepo.findById(id);
		if(oprod.isPresent()) {
			Producto prod = buscarPorId(id);
			prod.setNombre(prodm.getNombre());
			prodRepo.save(prod);
			
			// Editar el producto
			prod.setNombre(prodm.getNombre());
			prod.setDescripcion(prodm.getDescripcion());
			prod.setSku(prodm.getSku());
			prod.setPdf_caracteristicas(prodm.getPdf_caracteristicas());
			prod.setImg_primaria(""); //TODO: imagen
			prod.setImg_secundaria(""); //TODO: imagen
			prod.setStock(prodm.getStock());
			prod.setPrecio_soles(prodm.getPrecio_soles());
			
			prod.setFecha_modificacion(LocalDateTime.now());
			
			// Asignar categoria
			Optional<Categoria> oCat = catRepo.findById(prodm.getCategoria().getId());
			Categoria cat = oCat.get();
			
			prod.setCategoria(cat);
			cat.getProductos().add(prod);
			
			// Guardar producto
			prod = prodRepo.save(prod);
			
			// Eliminar caracteristicas anteriores
			carprodRepo.eliminarPorProducto(prod);
			
			// Crear características nuevamente
			if(prodm.getCaracteristicas() != null) {
				carprodRepo.saveAll(insertarCaracteristicas(prod, prodm.getCaracteristicas()));
			}
		}
	}
	
	//Eliminar
	public void eliminarProducto(int id) {
		Optional<Producto> oprod = prodRepo.findById(id);
		if(oprod.isPresent()) {
			Producto car = buscarPorId(id);
			car.setActivo(false);
			prodRepo.save(car);
		}
	}
	
	private List<CaracteristicaProducto> insertarCaracteristicas(Producto prod, Set<CaracteristicaProductoDTOForInsert> icarprods){
		List<CaracteristicaProducto> carprods = new ArrayList<>();
		for(CaracteristicaProductoDTOForInsert icarprod : icarprods) {
			// Obtener la característica a insertar
			Integer id_caracteristica = icarprod.getId_caracteristica();
			Caracteristica car = new Caracteristica();
			
			// Crear caracteristica si no existe
			if(id_caracteristica == null) {
				// Crear nueva categoria
				car.setNombre(icarprod.getNombre_caracteristica().strip());
				car.setActivo(true);
				car = carRepo.save(car);
			} else {
				// Buscar la caracteristica por su id
				car = carRepo.findById(id_caracteristica).get();
			}
			
			CaracteristicaProducto carprod = new CaracteristicaProducto();
			carprod.setCaracteristica(car);
			carprod.setProducto(prod);
			carprod.setValor(icarprod.getValor());
			carprods.add(carprod);
		}
		return carprods;
	}
	
	private Producto buscarPorId(Integer id) {
		return prodRepo.listarUno(id).orElseThrow(() -> new IdNotFoundException("producto"));
	}
	
	
}
