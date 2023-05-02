package com.andrea.ta27.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrea.ta27.dao.PiezasDAO;
import com.andrea.ta27.dto.Piezas;

@Service 
public class PiezasService {
	@Autowired
	PiezasDAO piezasDAO;

	public List<Piezas> listarPiezas() {
		return piezasDAO.findAll();
	}

	public Piezas guardarPieza(Piezas pieza) {
		return piezasDAO.save(pieza);
	}

	public Piezas piezaXID(int id) {
		return piezasDAO.findById(id).get();
	}

	public Piezas actualizarPieza(Piezas pieza) {
		return piezasDAO.save(pieza);
	}

	public void eliminarPieza(int id) {
		piezasDAO.deleteById(id);
	}
}
