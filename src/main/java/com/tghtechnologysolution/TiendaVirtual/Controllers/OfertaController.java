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

import com.tghtechnologysolution.TiendaVirtual.Services.OfertaService;
import com.tghtechnologysolution.TiendaVirtual.Util.IdNotFoundException;
import com.tghtechnologysolution.TiendaVirtual.dto.Oferta.OfertaDTOForInsert;
import com.tghtechnologysolution.TiendaVirtual.dto.Oferta.OfertaDTOForList;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/oferta")
public class OfertaController {
	
	@Autowired
	private OfertaService oferService;
	
	@PostMapping
	public ResponseEntity<Void> crearOferta(@Valid @RequestBody OfertaDTOForInsert ofer) {
        try {
        	//Validar datos
        	
            oferService.crearOferta(ofer);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
	@GetMapping
	public ResponseEntity<List<OfertaDTOForList>> listarOfertas(){
        try {
        	List<OfertaDTOForList> ofers = oferService.listarOfertas();
    		return ResponseEntity.status(HttpStatus.OK).body(ofers);
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<OfertaDTOForList>());
        }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OfertaDTOForList> listarOfertas(@PathVariable Integer id){
        try {
        	OfertaDTOForList ofer = oferService.listarOferta(id);
    		return ResponseEntity.status(HttpStatus.OK).body(ofer);
        } catch (IdNotFoundException ex) {
        	ex.printWarn();
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> modificarOferta(@PathVariable Integer id,
												@Valid @RequestBody OfertaDTOForInsert ofer){
		
        try {
        	//Validar datos
        	
        	oferService.modificarOferta(id, ofer);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (IdNotFoundException ex) {
        	ex.printWarn();
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarOferta(@PathVariable Integer id){
        try {
        	oferService.eliminarOferta(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (IdNotFoundException ex) {
        	ex.printWarn();
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
}
