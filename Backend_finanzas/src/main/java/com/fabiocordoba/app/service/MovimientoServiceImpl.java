package com.fabiocordoba.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiocordoba.app.entity.Movimiento;
import com.fabiocordoba.app.repository.MovimientoRepository;

@Service
public class MovimientoServiceImpl implements MovimientoService{
	
	@Autowired
	private MovimientoRepository repomovimiento;

	@Override
	public List<Movimiento> getAll() {
		// TODO Auto-generated method stub
		return  repomovimiento.findAll();
	}

	@Override
	public Optional<Movimiento> getMovimiento(long id) {
		// TODO Auto-generated method stub
		return repomovimiento.findById(id);
	}

	@Override
	public Movimiento save(Movimiento movimiento) {
	return repomovimiento.save(movimiento);
	
	}

	@Override
	public void delete(Movimiento movimiento) {
	 
	  repomovimiento.delete(movimiento);
	}

	@Override
	public void update(Movimiento movimiento) {
		
		
		if(this.getMovimiento(movimiento.getId()).isPresent()) {
			movimiento.setDescripcion(movimiento.getDescripcion());
			movimiento.setMonto(movimiento.getMonto());
			movimiento.setMovimiento(movimiento.isMovimiento());
			repomovimiento.save(movimiento);
		}
		 
		
	}

	 

}
