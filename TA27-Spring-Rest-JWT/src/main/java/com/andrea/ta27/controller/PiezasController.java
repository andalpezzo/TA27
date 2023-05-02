package com.andrea.ta27.controller;

import com.andrea.ta27.dto.Piezas;
import com.andrea.ta27.service.PiezasService;

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
public class PiezasController {
	
	@Autowired
	PiezasService piezasService;
	
	@GetMapping("/piezas")
	public List<Piezas> listarPiezas(){
		return piezasService.listarPiezas();
	}
	
	
	@PostMapping("/piezas")
	public Piezas salvarPieza(@RequestBody Piezas pieza) {
		
		return piezasService.guardarPieza(pieza);
	}
	
	
	@GetMapping("/piezas/{id}")
	public Piezas piezaXID(@PathVariable(name="id") int id) {
		
		Piezas pieza_xid= new Piezas();
		
		pieza_xid=piezasService.piezaXID(id);
		
		System.out.println("Curso XID: "+pieza_xid);
		
		return pieza_xid;
	}
	
	@PutMapping("/piezas/{id}")
	public Piezas actualizarPieza(@PathVariable(name="id")int id,@RequestBody Piezas pieza) {
		
		Piezas pieza_seleccionada= new Piezas();
		Piezas pieza_actualizada= new Piezas();
		
		pieza_seleccionada= piezasService.piezaXID(id);
		
		pieza_seleccionada.setNombre(pieza.getNombre());
		
		pieza_actualizada = piezasService.actualizarPieza(pieza_seleccionada);
		
		System.out.println("El Curso actualizado es: "+ pieza_actualizada);
		
		return pieza_actualizada;
	}
	
	@DeleteMapping("/piezas/{id}")
	public void eliminarPieza(@PathVariable(name="id")int id) {
		piezasService.eliminarPieza(id);
	}
}
