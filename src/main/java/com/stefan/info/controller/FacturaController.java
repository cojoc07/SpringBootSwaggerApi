package com.stefan.info.controller;

import com.stefan.info.controller.dto.FacturaResponseRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stefan.info.model.Factura;
import com.stefan.info.service.FacturaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController    
@RequestMapping(path="/facturi") 
public class FacturaController {
	
	@Autowired
	FacturaService facturaService;
	
	@GetMapping(path="/add")
	public Factura adaugaFactura (@RequestParam Integer id_comanda) {

		List<Factura> lista = facturaService.findAll();
		for (Factura f: lista){
			if (f.getComanda().getId() == id_comanda){
				throw new RuntimeException("Exista deja factura pentru comanda cu id " + id_comanda);
			}
		}
		Factura factura = facturaService.creazaFactura(id_comanda);
		return factura;
	}
	
	@GetMapping(path="/all")
	public List<FacturaResponseRepresentation> getAllFacturi() {
		return facturaService.findAll()
				.stream()
				.map(FacturaResponseRepresentation::convert)
				.collect(Collectors.toList());
	}
	
	@GetMapping(path="/all/{facturaId}")
	public FacturaResponseRepresentation getFacturaById(@PathVariable int facturaId) {
		return FacturaResponseRepresentation.convert(facturaService.findById(facturaId));
	}
	
	@DeleteMapping(path="/all/{facturaId}")
	public void deleteFacturaById(@PathVariable int facturaId) {
		facturaService.deleteById(facturaId);
	}
}
