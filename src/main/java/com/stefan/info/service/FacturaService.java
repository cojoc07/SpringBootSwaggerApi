package com.stefan.info.service;

import java.util.List;
import java.util.Optional;

import com.stefan.info.repository.ComandaRepository;
import com.stefan.info.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefan.info.model.Comanda;
import com.stefan.info.model.Factura;

@Service
public class FacturaService {
	@Autowired
	private ComandaRepository comandaRepository;
	@Autowired
	private FacturaRepository facturaRepository;
	
	public Factura creazaFactura(Integer id_comanda) {
		Comanda c = null;
		Float suma = null;

		Optional<Comanda> comanda = comandaRepository.findById(id_comanda);
		if (!comanda.isPresent())
			throw new RuntimeException("comanda cu id-ul "+  + id_comanda+  " nu exista");


		c = comandaRepository.findById(id_comanda).get();
		suma = c.getSuma();


		Factura f = new Factura();
		f.setSuma(suma);
		f.setComanda(c);
		
		facturaRepository.save(f);
		
		return f;
	}
	
	public List<Factura> findAll(){
		return facturaRepository.findAll();
	}
	
	public Factura findById(int id) {
		Optional<Factura> factura = facturaRepository.findById(id);

		if (!factura.isPresent())
			throw new RuntimeException("factura cu id-ul "+  + id+  " nu exista");

		return factura.get();
	} 
	
	public void deleteById(int id) {
		Optional<Factura> factura = facturaRepository.findById(id);
		if (!factura.isPresent())
			throw new RuntimeException("factura cu id-ul "+  + id+  " nu exista");

		facturaRepository.deleteById(id);
	}
}
