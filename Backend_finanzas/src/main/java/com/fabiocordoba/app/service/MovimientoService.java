package com.fabiocordoba.app.service;

import java.util.List;
import java.util.Optional;

import com.fabiocordoba.app.entity.Movimiento;

public interface MovimientoService {

	public List<Movimiento> getAll();
	
	public Optional<Movimiento>getMovimiento(long id);
	 
	
	public Movimiento save(Movimiento movimiento);
	
	public void delete(Movimiento movimiento);

	public void update(Movimiento movimiento);
	
	
	
	 
	
}
