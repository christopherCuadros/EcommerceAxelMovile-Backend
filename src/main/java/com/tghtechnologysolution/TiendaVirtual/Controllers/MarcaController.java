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

import com.tghtechnologysolution.TiendaVirtual.Services.MarcaService;
import com.tghtechnologysolution.TiendaVirtual.Util.IdNotFoundException;
import com.tghtechnologysolution.TiendaVirtual.dto.Marca.MarcaDTOForInsert;
import com.tghtechnologysolution.TiendaVirtual.dto.Marca.MarcaDTOForList;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/marca")
public class MarcaController {
	
	@Autowired
	private MarcaService marService;
	
	@PostMapping
	public ResponseEntity<Void> crearMarca(@Valid @RequestBody MarcaDTOForInsert mar) {
        try {
        	//Validar datos
        	if(mar.getDescripcion() == null || mar.getDescripcion().strip().equals(""))
        		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        	
            marService.crearMarca(mar);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
        	e.printStackTrace();
        	//System.out.println();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
	@GetMapping
	public ResponseEntity<List<MarcaDTOForList>> listarMarcas(){
        try {
        	List<MarcaDTOForList> mars = marService.listarMarcas();
    		return ResponseEntity.status(HttpStatus.OK).body(mars);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<MarcaDTOForList>());
        }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MarcaDTOForList> listarMarcas(@PathVariable Integer id){
        try {
        	MarcaDTOForList mar = marService.listarMarca(id);
    		return ResponseEntity.status(HttpStatus.OK).body(mar);
        } catch (IdNotFoundException ex) {
        	ex.printWarn();
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> modificarMarca(@PathVariable Integer id,
												@Valid @RequestBody MarcaDTOForInsert mar){
		
        try {
        	//Validar datos
        	if(mar.getDescripcion() == null || mar.getDescripcion().strip().equals(""))
        		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        	
            marService.modificarMarca(id, mar);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (IdNotFoundException ex) {
        	ex.printWarn();
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarMarca(@PathVariable Integer id){
        try {
            marService.eliminarMarca(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (IdNotFoundException ex) {
        	ex.printWarn();
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
}