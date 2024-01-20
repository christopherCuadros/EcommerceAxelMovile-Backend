package com.tghtechnologysolution.TiendaVirtual.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tghtechnologysolution.TiendaVirtual.Models.Caracteristica;
import com.tghtechnologysolution.TiendaVirtual.Models.Oferta;
import com.tghtechnologysolution.TiendaVirtual.Models.Producto;
import com.tghtechnologysolution.TiendaVirtual.Repository.OfertaRepository;
import com.tghtechnologysolution.TiendaVirtual.Repository.ProductoRepository;
import com.tghtechnologysolution.TiendaVirtual.Util.IdNotFoundException;
import com.tghtechnologysolution.TiendaVirtual.dto.Categoria.CategoriaDTOForList;
import com.tghtechnologysolution.TiendaVirtual.dto.Marca.MarcaDTOForList;
import com.tghtechnologysolution.TiendaVirtual.dto.Oferta.OfertaDTOForInsert;
import com.tghtechnologysolution.TiendaVirtual.dto.Oferta.OfertaDTOForList;
import com.tghtechnologysolution.TiendaVirtual.dto.Producto.ProductoDTOForList;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OfertaService {
	
	@Autowired
	private OfertaRepository oferRepo;
	private ProductoRepository prodRepo;
	
	//Crear
	public OfertaDTOForList crearOferta(OfertaDTOForInsert iOfer) {
		Oferta ofer = new Oferta();
		
		// Añadir datos
		ofer.setPorcentaje(iOfer.getPorcentaje());
		ofer.setNuevo_precio(iOfer.getNuevo_precio());
		ofer.setFecha_inicio(iOfer.getFecha_inicio());
		ofer.setFecha_finalizacion(iOfer.getFecha_finalizacion());
		ofer.setActivo(true);
		
		// Añadir producto TODO: validar id del producto
		ofer.setProducto(prodRepo.findById(iOfer.getId_producto()).get());
		oferRepo.save(ofer);
		
		return new OfertaDTOForList(ofer);
	}
	
	//Listar
	public List<OfertaDTOForList> listarOfertas(){
		List<OfertaDTOForList> oferList = new ArrayList<>();
		//List<Categoria> cats = (List<Categoria>) catRepo.findAll();
		List<Oferta> ofers = (List<Oferta>) oferRepo.listar();
		
		/*for(Oferta ofer : ofers) {
			OfertaDTOForList o = new OfertaDTOForList();
			o.setId(ofer.getId());
			o.setPorcentaje(ofer.getPorcentaje());
			o.setNuevo_precio(ofer.getNuevo_precio());
			o.setFecha_inicio(ofer.getFecha_inicio());
			o.setFecha_finalizacion(ofer.getFecha_finalizacion());
			//Producto
			Producto prod = ofer.getProducto();
			ProductoDTOForList p = new ProductoDTOForList();
			p.setId(prod.getId());
			p.setNombre(prod.getNombre());
			o.setProducto(p);
			
			
			oferList.add(o);
		}*/
		
		//For -> ForEach
		ofers.forEach(ofer -> {
			oferList.add(new OfertaDTOForList(ofer));
		});
		
		return oferList;
	}
	
	//Listar Uno
	public OfertaDTOForList listarOferta(int id){
		OfertaDTOForList o = null;
		Optional<Oferta> oofer = oferRepo.listarUno(id);
		if(oofer.isPresent()) {
			Oferta ofer = buscarPorId(id);
			o = new OfertaDTOForList();
			o.setId(ofer.getId());
			o.setPorcentaje(ofer.getPorcentaje());
			o.setNuevo_precio(ofer.getNuevo_precio());
			o.setFecha_inicio(ofer.getFecha_inicio());
			o.setFecha_finalizacion(ofer.getFecha_finalizacion());
			//Producto
			Producto prod = ofer.getProducto();
			ProductoDTOForList p = new ProductoDTOForList();
			p.setId(prod.getId());
			p.setNombre(prod.getNombre());
			o.setProducto(p);
		}
		return o;
	}
	
	//Modificar
	public void modificarOferta(Integer id, OfertaDTOForInsert oferm) {
		Optional<Oferta> oofer = oferRepo.findById(id);
		if(oofer.isPresent()) {
			Oferta ofer = buscarPorId(id);
			// Añadir datos
			ofer.setPorcentaje(oferm.getPorcentaje());
			ofer.setNuevo_precio(oferm.getNuevo_precio());
			ofer.setFecha_inicio(oferm.getFecha_inicio());
			ofer.setFecha_finalizacion(oferm.getFecha_finalizacion());
			ofer.setActivo(true);
			
			// Añadir producto TODO: validar id del producto
			ofer.setProducto(prodRepo.findById(oferm.getId_producto()).get());
			oferRepo.save(ofer);
		}
	}
	
	//Eliminar
	public void eliminarOferta(int id) {
		Optional<Oferta> oofer = oferRepo.findById(id);
		if(oofer.isPresent()) {
			Oferta ofer = buscarPorId(id);
			ofer.setActivo(false);
			oferRepo.save(ofer);
		}
	}
	
	private Oferta buscarPorId(Integer id) {
		return oferRepo.listarUno(id).orElseThrow(() -> new IdNotFoundException("oferta"));
	}
}
