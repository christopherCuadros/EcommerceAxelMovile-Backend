package com.tghtechnologysolution.TiendaVirtual.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tghtechnologysolution.TiendaVirtual.Models.Caracteristica;
import com.tghtechnologysolution.TiendaVirtual.Repository.CaracteristicaRepository;
import com.tghtechnologysolution.TiendaVirtual.Util.IdNotFoundException;
import com.tghtechnologysolution.TiendaVirtual.dto.Caracteristica.CaracteristicaDTOForInsert;
import com.tghtechnologysolution.TiendaVirtual.dto.Caracteristica.CaracteristicaDTOForList;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CaracteristicaService {
	
	@Autowired
	private CaracteristicaRepository carRepo;
	
	//Crear
	public CaracteristicaDTOForList crearCaracteristica(CaracteristicaDTOForInsert iCar) {
		Caracteristica car = new Caracteristica();
		car.setNombre(iCar.getNombre().strip());
		car.setActivo(true);
		car = carRepo.save(car);
		
		return new CaracteristicaDTOForList(car);
	}
	
	//Listar
	public List<CaracteristicaDTOForList> listarCaracteristicas(){
		List<CaracteristicaDTOForList> carList = new ArrayList<>();
		List<Caracteristica> cars = (List<Caracteristica>) carRepo.listar();
		/*
		for(Caracteristica car : cars) {
			CaracteristicaDTOForList c = new CaracteristicaDTOForList();
			c.setId(car.getId());
			c.setNombre(car.getNombre());
			carList.add(c);
		}*/
		cars.forEach(car -> {
			carList.add(new CaracteristicaDTOForList(car));
		});
		
		return carList;
	}
	
	//Listar Uno
	public CaracteristicaDTOForList listarCaracteristica(int id){
		Caracteristica car = buscarPorId(id);
		return new CaracteristicaDTOForList(car);
	}
	
	//Modificar
	public void modificarCaracteristica(Integer id, CaracteristicaDTOForInsert carm) {
		Caracteristica car = buscarPorId(id);
		car.setNombre(carm.getNombre().strip());
		carRepo.save(car);
	}
	
	//Eliminar
	public void eliminarCaracteristica(int id) {
		Caracteristica car = buscarPorId(id);
		car.setActivo(false);
		carRepo.save(car);
	}
	
	private Caracteristica buscarPorId(Integer id) {
		return carRepo.listarUno(id).orElseThrow(() -> new IdNotFoundException("caracteristica"));
	}
	
}
