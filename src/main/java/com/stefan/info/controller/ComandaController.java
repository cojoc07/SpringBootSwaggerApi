package com.stefan.info.controller;

import com.stefan.info.controller.dto.ComandaRequestRepresentation;
import com.stefan.info.controller.dto.ComandaResponseRepresentation;
import com.stefan.info.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stefan.info.model.Comanda;
import com.stefan.info.service.ComandaService;

import java.util.List;

@RestController    
@RequestMapping(path="/comenzi") 
public class ComandaController {
	
	@Autowired
	private ComandaService comandaService;
	@Autowired
	private UserService userService;
	
	@GetMapping(path="/add")
	public Comanda addNewComanda (@RequestParam float suma, @RequestParam int id_user,
			@RequestParam String descriere,
			@RequestParam(required=false) Integer id_factura) {

		Comanda comanda = comandaService.addNewComanda(suma, id_user, descriere, id_factura);
		return comanda;
	}
	
	@GetMapping(path="/all")
	public List<Comanda> getAllComenzi() {
		return comandaService.findAll();
	}
	
	@GetMapping(path="/all/{comandaId}")
	public Comanda getComandaById(@PathVariable int comandaId) {
		return comandaService.findById(comandaId);
	}
	
	@DeleteMapping(path="/all/{comandaId}")
	public void deleteComandaById(@PathVariable int comandaId) {
		comandaService.deleteById(comandaId);
	}



	@PostMapping(path="all/addComanda")
	public ComandaResponseRepresentation postCreate(@RequestBody ComandaRequestRepresentation comanda) {
		Comanda nou = new Comanda();

		nou.setDescriere(comanda.getDescriere());
		nou.setFactura(comanda.getFactura());
		nou.setSuma(comanda.getSuma());

		nou.setUser(userService.findById(comanda.getUser()));

		comandaService.save(nou);
		return ComandaResponseRepresentation.convertFaraFactura(nou);
	}
}
