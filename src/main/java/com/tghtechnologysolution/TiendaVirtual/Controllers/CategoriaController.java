package com.tghtechnologysolution.TiendaVirtual.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tghtechnologysolution.TiendaVirtual.Services.CategoriaService;
import com.tghtechnologysolution.TiendaVirtual.Util.IdNotFoundException;
import com.tghtechnologysolution.TiendaVirtual.dto.Categoria.CategoriaDTOForInsert;
import com.tghtechnologysolution.TiendaVirtual.dto.Categoria.CategoriaDTOForList;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService catService;
	
	@PostMapping
	public ResponseEntity<Void> crearCategoria(@Valid @RequestBody CategoriaDTOForInsert cat) {
        try {
        	//Validar datos
        	if(cat.getDescripcion() == null)
        		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
				
            catService.crearCategoria(cat);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
        	e.printStackTrace();
        	//System.out.println();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTOForList>> listarCategorias(){
        try {
        	List<CategoriaDTOForList> cats = catService.listarCategorias();
    		return ResponseEntity.status(HttpStatus.OK).body(cats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<CategoriaDTOForList>());
        }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDTOForList> listarCategorias(@PathVariable Integer id){
        try {
        	CategoriaDTOForList cat = catService.listarCategoria(id);
    		return ResponseEntity.status(HttpStatus.OK).body(cat);
        } catch (IdNotFoundException ex) {
        	ex.printWarn();
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> modificarCategoria(@PathVariable Integer id,
												   @Valid @RequestBody CategoriaDTOForInsert cat){
		
        try {
        	//Validar datos
        	if(cat.getDescripcion() == null || cat.getDescripcion().strip().equals(""))
        		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        	
            catService.modificarCategoria(id, cat);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (IdNotFoundException ex) {
        	ex.printWarn();
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarCategoria(@PathVariable Integer id){
        try {
            catService.eliminarCategoria(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (IdNotFoundException ex) {
        	ex.printWarn();
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
	}
	
}
