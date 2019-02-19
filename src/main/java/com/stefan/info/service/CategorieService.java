package com.stefan.info.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.stefan.info.repository.PostareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefan.info.model.Categorie;
import com.stefan.info.repository.CategorieRepository;

@Service
public class CategorieService {

	@Autowired
	private PostareRepository postareRepository;
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	public Categorie adaugaCategorie(String denumire) {
		
		Categorie c = new Categorie();
		c.setDenumire(denumire);
		c.setPosts(null);
		
		categorieRepository.save(c);
		
		return c;
	}
	
	public List<Categorie> findAll(){
		return categorieRepository.findAll();
	}
	
	public Categorie findById(int id) {

		Optional<Categorie> categorieOptional = categorieRepository.findById(id);

		if (!categorieOptional.isPresent())
			throw new RuntimeException("categoria cu id-ul "+  + id+  " nu exista");

		return categorieOptional.get();
	} 
	
	public void deleteById(int id) {
		categorieRepository.deleteById(id);
	}

	public Categorie save(Categorie categorie){
		categorieRepository.save(categorie);
		return categorie;
	}
}
