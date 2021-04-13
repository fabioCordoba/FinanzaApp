package com.fabiocordoba.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabiocordoba.app.entity.Movimiento;
import com.fabiocordoba.app.entity.User;
import com.fabiocordoba.app.service.MovimientoService;
import com.fabiocordoba.app.service.UserService;
@RestController
@RequestMapping("/api/Movimiento")
public class MovimientoController {

	
	@Autowired
	private MovimientoService service;
	
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Movimiento movimiento){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(movimiento));
	}
	@GetMapping
	public List<Movimiento >findAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	
	public ResponseEntity<?> get(@PathVariable long id){
		 Optional<Movimiento >movimient=service.getMovimiento(id);
		 
		 if(movimient.isPresent()==false) {
			 return ResponseEntity.notFound().build();
		 }
	return ResponseEntity.ok(movimient.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		
		 Optional<Movimiento >movimient=service.getMovimiento(id);
		 Movimiento movimiento=movimient.get();
		 if(!movimient.isPresent()) {
			 return ResponseEntity.notFound().build();
		 }
		
		 service.delete(movimiento);
		 return ResponseEntity.ok("Eliminado correctamente");
		 
		 
		 
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Movimiento movimiento){
		 Optional<Movimiento >movimient=service.getMovimiento(movimiento.getId());
		 
		 if(!movimient.isPresent()) {
			 return ResponseEntity.notFound().build();
		 }
		 
		 service.update(movimiento);
		 
		 return ResponseEntity.ok(movimiento);
		 
		 
	}
	
	 
	
	
	
	
	
}


