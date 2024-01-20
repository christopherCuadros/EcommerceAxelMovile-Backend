package com.tghtechnologysolution.TiendaVirtual.Controllers;

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

import com.tghtechnologysolution.TiendaVirtual.Services.CaracteristicaService;
import com.tghtechnologysolution.TiendaVirtual.Util.IdNotFoundException;
import com.tghtechnologysolution.TiendaVirtual.dto.Caracteristica.CaracteristicaDTOForInsert;
import com.tghtechnologysolution.TiendaVirtual.dto.Caracteristica.CaracteristicaDTOForList;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/caracteristica")
public class CaracteristicaController {
	
	@Autowired
	private CaracteristicaService carService;
	
	@PostMapping
	public ResponseEntity<CaracteristicaDTOForList> crearCaracteristica(@Valid @RequestBody CaracteristicaDTOForInsert car) {
        try {
        	//Validar datos
        	if(car.getNombre() == null || car.getNombre().strip().equals(""))
        		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        	
            CaracteristicaDTOForList creado = carService.crearCaracteristica(car);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
	@GetMapping
	public ResponseEntity<List<CaracteristicaDTOForList>> listarCaracteristicas(){
        try {
        	List<CaracteristicaDTOForList> cars = carService.listarCaracteristicas();
    		return ResponseEntity.status(HttpStatus.OK).body(cars);
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CaracteristicaDTOForList> listarCaracteristicas(@PathVariable Integer id){
        try {
        	CaracteristicaDTOForList car = carService.listarCaracteristica(id);
    		return ResponseEntity.status(HttpStatus.OK).body(car);
        } catch (IdNotFoundException ex) {
        	ex.printWarn();
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> modificarCaracteristica(@PathVariable Integer id,
														@Valid @RequestBody CaracteristicaDTOForInsert car){
        try {
        	//Validar datos
        	if(car.getNombre() == null || car.getNombre().strip().equals(""))
        		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        	
            carService.modificarCaracteristica(id, car);
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
	public ResponseEntity<Void> eliminarCaracteristica(@PathVariable Integer id){
        try {
            carService.eliminarCaracteristica(id);
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
