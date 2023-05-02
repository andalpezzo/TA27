package com.andrea.ta27.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrea.ta27.dao.SuministraDAO;
import com.andrea.ta27.dto.Suministra;

@Service 
public class SuministraService {
	@Autowired
	SuministraDAO suministraDAO;

	public List<Suministra> listarSuministra() {
		return suministraDAO.findAll();
	}

	public Suministra guardarSuministra(Suministra suministra) {
		return suministraDAO.save(suministra);
	}

	public Suministra suministraXID(int id) {
		return suministraDAO.findById(id).get();
	}

	public Suministra actualizarSuministra(Suministra suministra) {
		return suministraDAO.save(suministra);
	}

	public void eliminarSuministra(int id) {
		suministraDAO.deleteById(id);
	}
}