package com.andrea.ta27.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrea.ta27.dto.Piezas;

public interface PiezasDAO extends JpaRepository<Piezas, Integer>{
	
}