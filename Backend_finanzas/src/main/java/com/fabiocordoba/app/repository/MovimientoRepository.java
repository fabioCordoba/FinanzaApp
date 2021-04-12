package com.fabiocordoba.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiocordoba.app.entity.Movimiento;
 
@Repository
public interface MovimientoRepository  extends  JpaRepository<Movimiento, Long>{

 
	
	
	
	

}
