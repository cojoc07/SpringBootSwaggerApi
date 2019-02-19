package com.stefan.info.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.stefan.info.model.Categorie;
import com.stefan.info.repository.CategorieRepository;
import com.stefan.info.repository.PostareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefan.info.model.Postare;

@Service
public class PostareService {
	
	@Autowired
	private PostareRepository postareRepository;
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	public Postare creazaPostare(String mesaj) {
		
		Postare p = new Postare();
		p.setMesaj(mesaj);
		p.setCategorii(null);
		
		postareRepository.save(p);
		
		return p;
	}
	
	public List<Postare> findAll(){
		return postareRepository.findAll();
	}
	
	public Postare findById(int id) {
		Optional<Postare> postare = postareRepository.findById(id);

		if (!postare.isPresent())
			throw new RuntimeException("postarea cu id-ul "+  + id+  " nu exista");

		return postare.get();
	} 
	
	public void deleteById(int id) {
		postareRepository.deleteById(id);
	}

	public void adaugaCategorieLaPostare(int idPostare, int categorieId) {



		Categorie care = categorieRepository.getOne(categorieId);

		Optional<Postare> load = postareRepository.findById(idPostare);
		if (load.isPresent()){
			Postare postare = load.get();
			postare.getCategorii().add(care);
			postareRepository.save(postare);
		}
	}
}
