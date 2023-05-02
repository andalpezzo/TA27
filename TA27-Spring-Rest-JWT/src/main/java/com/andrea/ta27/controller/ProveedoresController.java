package com.andrea.ta27.controller;

import com.andrea.ta27.dto.Proveedores;
import com.andrea.ta27.service.ProveedoresService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProveedoresController {
	
	@Autowired
	ProveedoresService proveedoresService;
	
	@GetMapping("/proveedores")
	public List<Proveedores> listarProveedores(){
		return proveedoresService.listarProveedores();
	}
	
	
	@PostMapping("/proveedores")
	public Proveedores salvarProveedores(@RequestBody Proveedores proveedor) {
		
		return proveedoresService.guardarProveedor(proveedor);
	}
	
	
	@GetMapping("/proveedores/{id}")
	public Proveedores proveedorXID(@PathVariable(name="id") int id) {
		
		Proveedores pieza_xid= new Proveedores();
		
		pieza_xid=proveedoresService.proveedorXID(id);
		
		System.out.println("Curso XID: "+pieza_xid);
		
		return pieza_xid;
	}
	
	@PutMapping("/proveedores/{id}")
	public Proveedores actualizarProveedor(@PathVariable(name="id")int id,@RequestBody Proveedores pieza) {
		
		Proveedores proveedor_seleccionado= new Proveedores();
		Proveedores proveedor_actualizado= new Proveedores();
		
		proveedor_seleccionado= proveedoresService.proveedorXID(id);
		
		proveedor_seleccionado.setNombre(pieza.getNombre());
		
		proveedor_actualizado = proveedoresService.actualizarProveedor(proveedor_seleccionado);
		
		System.out.println("El Curso actualizado es: "+ proveedor_actualizado);
		
		return proveedor_actualizado;
	}
	
	@DeleteMapping("/proveedores/{id}")
	public void eliminarProveedor(@PathVariable(name="id")int id) {
		proveedoresService.eliminarProveedor(id);
	}
}
