package com.tghtechnologysolution.TiendaVirtual.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tghtechnologysolution.TiendaVirtual.Models.Caracteristica;
import com.tghtechnologysolution.TiendaVirtual.Models.Marca;
import com.tghtechnologysolution.TiendaVirtual.Repository.MarcaRepository;
import com.tghtechnologysolution.TiendaVirtual.Util.IdNotFoundException;
import com.tghtechnologysolution.TiendaVirtual.dto.Caracteristica.CaracteristicaDTOForList;
import com.tghtechnologysolution.TiendaVirtual.dto.Categoria.CategoriaDTOForList;
import com.tghtechnologysolution.TiendaVirtual.dto.Marca.MarcaDTOForInsert;
import com.tghtechnologysolution.TiendaVirtual.dto.Marca.MarcaDTOForList;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MarcaService {

	private MarcaRepository marRepo;
	
	//Crear
		public MarcaDTOForList crearMarca(MarcaDTOForInsert iMar) {
			Marca mar = new Marca();
			mar.setNombre(iMar.getNombre().strip());
			mar.setDescripcion(iMar.getDescripcion().strip());
			mar.setImagen(iMar.getImagen());
			mar.setActivo(true);
			marRepo.save(mar);
			
			return new MarcaDTOForList(mar);
			
		}
		
	//Listar
		public List<MarcaDTOForList> listarMarcas(){
			List<MarcaDTOForList> marList = new ArrayList<>();
			//List<Marca> mars = (List<Marca>) marRepo.findAll();
			List<Marca> mars = (List<Marca>) marRepo.listar();
			
			/*for(Marca mar : mars) {
				MarcaDTOForList c = new MarcaDTOForList();
				c.setId(mar.getId());
				c.setNombre(mar.getNombre());
				c.setDescripcion(mar.getDescripcion());
				c.setImagen(mar.getImagen());
				marList.add(c);
			}*/
			
			//For -> ForEach
			mars.forEach(mar -> {
				marList.add(new MarcaDTOForList(mar));
			});
			
			return marList;
		}
		
	//Listar Uno
		public MarcaDTOForList listarMarca(int id){
			MarcaDTOForList c = null;
			Optional<Marca> omar = marRepo.listarUno(id);
			if(omar.isPresent()) {
				Marca mar = buscarPorId(id);
				c = new MarcaDTOForList();
				c.setId(mar.getId());
				c.setNombre(mar.getNombre());
				c.setDescripcion(mar.getDescripcion());
				c.setImagen(mar.getImagen());
			}
			return c;
		}
		
	//Modificar
		public void modificarMarca(Integer id, MarcaDTOForInsert marm) {
			Optional<Marca> omar = marRepo.findById(id);
			if(omar.isPresent()) {
				Marca mar = buscarPorId(id);
				mar.setNombre(marm.getNombre().strip());
				mar.setDescripcion(marm.getDescripcion().strip());
				mar.setImagen(marm.getImagen());
				marRepo.save(mar);
			}
		}
		
		
	//Eliminar
		public void eliminarMarca(int id) {
			
				Marca mar = buscarPorId(id);
				mar.setActivo(false);
				marRepo.save(mar);
		
		}
		
		private Marca buscarPorId(Integer id) {
			return marRepo.listarUno(id).orElseThrow(() -> new IdNotFoundException("marca"));
		}
}
