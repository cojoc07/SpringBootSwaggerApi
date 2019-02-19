package com.stefan.info.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.stefan.info.controller.dto.ComandaResponseRepresentation;
import com.stefan.info.repository.ComandaRepository;
import com.stefan.info.repository.FacturaRepository;
import com.stefan.info.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefan.info.model.Comanda;
import com.stefan.info.model.Factura;
import com.stefan.info.model.User;

@Service
public class ComandaService {
	@Autowired
	private ComandaRepository comandaRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FacturaRepository facturaRepository;
	
	public Comanda addNewComanda(float suma, int id_user, String descriere, Integer id_factura) {
		User user = null;
		Factura factura = null;
		try {
			user = userRepository.findById(id_user).get();
			factura = facturaRepository.findById(id_factura).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Comanda c = new Comanda();
		c.setSuma(suma);
		c.setUser(user);
		c.setDescriere(descriere);
		c.setFactura(factura);
		
		comandaRepository.save(c);
		
		return c;
	}
	
	public List<Comanda> findAll(){
		return comandaRepository.findAll();
	}
	
	public Comanda findById(int id) {

		Optional<Comanda> comanda = comandaRepository.findById(id);

		if (!comanda.isPresent())
			throw new RuntimeException("comanda cu id-ul "+  + id+  " nu exista");

		return comanda.get();
	} 
	
	public void deleteById(int id) {

		comandaRepository.deleteById(id);
	}

	public ComandaResponseRepresentation save(Comanda comanda){
		comandaRepository.save(comanda);
		return ComandaResponseRepresentation.convertFaraFactura(comanda);
	}
	
}
