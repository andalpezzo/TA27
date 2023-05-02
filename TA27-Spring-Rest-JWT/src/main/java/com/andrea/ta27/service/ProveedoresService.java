package com.andrea.ta27.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrea.ta27.dao.ProveedoresDAO;
import com.andrea.ta27.dto.Proveedores;

@Service 
public class ProveedoresService {
	@Autowired
	ProveedoresDAO proveedoresDAO;

	public List<Proveedores> listarProveedores() {
		return proveedoresDAO.findAll();
	}

	public Proveedores guardarProveedor(Proveedores proveedor) {
		return proveedoresDAO.save(proveedor);
	}

	public Proveedores proveedorXID(int id) {
		return proveedoresDAO.findById(id).get();
	}

	public Proveedores actualizarProveedor(Proveedores proveedor) {
		return proveedoresDAO.save(proveedor);
	}

	public void eliminarProveedor(int id) {
		proveedoresDAO.deleteById(id);
	}
}
