package com.tghtechnologysolution.TiendaVirtual.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tghtechnologysolution.TiendaVirtual.Models.Categoria;
import com.tghtechnologysolution.TiendaVirtual.Repository.CategoriaRepository;
import com.tghtechnologysolution.TiendaVirtual.Util.IdNotFoundException;
import com.tghtechnologysolution.TiendaVirtual.dto.Caracteristica.CaracteristicaDTOForList;
import com.tghtechnologysolution.TiendaVirtual.dto.Categoria.CategoriaDTOForInsert;
import com.tghtechnologysolution.TiendaVirtual.dto.Categoria.CategoriaDTOForList;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository catRepo;
	
	//Crear
	public CategoriaDTOForList crearCategoria(CategoriaDTOForInsert iCat) {
		Categoria cat = new Categoria();
		cat.setDescripcion(iCat.getDescripcion().strip());
		cat.setActivo(true);
		catRepo.save(cat);
		
		return new CategoriaDTOForList(cat);
	}
	
	//Listar
	public List<CategoriaDTOForList> listarCategorias(){
		List<CategoriaDTOForList> catList = new ArrayList<>();
		List<Categoria> cats = (List<Categoria>) catRepo.listar();
		
		cats.forEach(cat -> {
			catList.add(new CategoriaDTOForList(cat));
		});
		
		return catList;
	}
	
	//Listar Uno
	public CategoriaDTOForList listarCategoria(int id){
		Categoria cat = buscarPorId(id);
		return new CategoriaDTOForList(cat);
	}
	
	//Modificar
	public void modificarCategoria(Integer id, CategoriaDTOForInsert catm) {
		Categoria cat = buscarPorId(id);
		cat.setDescripcion(catm.getDescripcion().strip());
		catRepo.save(cat);
	}
	
	//Eliminar
	public void eliminarCategoria(int id) {
		Categoria cat = buscarPorId(id);
		cat.setActivo(false);
		catRepo.save(cat);
	}
	
	private Categoria buscarPorId(Integer id) {
		return catRepo.listarUno(id).orElseThrow(() -> new IdNotFoundException("categoria"));
	}
	
}
