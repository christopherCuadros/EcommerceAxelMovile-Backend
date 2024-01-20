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

import com.tghtechnologysolution.TiendaVirtual.Services.ProductoService;
import com.tghtechnologysolution.TiendaVirtual.Util.IdNotFoundException;
import com.tghtechnologysolution.TiendaVirtual.dto.Producto.ProductoDTOForInsert;
import com.tghtechnologysolution.TiendaVirtual.dto.Producto.ProductoDTOForList;
import com.tghtechnologysolution.TiendaVirtual.dto.Producto.ProductoDTOFull;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService prodService;
	
	@PostMapping
	public ResponseEntity<Void> crearProducto(@Valid @RequestBody ProductoDTOForInsert prod) {
        try {
        	//Validar datos
        	if(prod.getNombre() == null || prod.getNombre().strip().equals(""))
        		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        	
            prodService.crearProducto(prod);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
	@GetMapping
	public ResponseEntity<List<ProductoDTOForList>> listarProductos(){
        try {
        	List<ProductoDTOForList> prods = prodService.listarProductos();
    		return ResponseEntity.status(HttpStatus.OK).body(prods);
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<ProductoDTOForList>());
        }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductoDTOFull> listarProducto(@PathVariable Integer id){
        try {
        	ProductoDTOFull prod = prodService.listarProducto(id);
    		return ResponseEntity.status(HttpStatus.OK).body(prod);
        } catch (IdNotFoundException ex) {
        	ex.printWarn();
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> modificarProducto(@PathVariable Integer id,
												  @Valid @RequestBody ProductoDTOForInsert prod){
        try {
        	//Validar datos
        	if(id == null)
        		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        	
            prodService.modificarProducto(id, prod);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (IdNotFoundException ex) {
        	ex.printWarn();
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id){
        try {
            prodService.eliminarProducto(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (IdNotFoundException ex) {
        	ex.printWarn();
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
}
