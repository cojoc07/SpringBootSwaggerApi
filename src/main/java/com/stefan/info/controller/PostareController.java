package com.stefan.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stefan.info.model.Postare;
import com.stefan.info.service.PostareService;

import java.util.List;

@RestController    
@RequestMapping(path="/postari") 
public class PostareController {
	
	@Autowired
	PostareService postareService;
	
	@GetMapping(path="/add")
	public Postare adaugaPostare (@RequestParam String mesaj) {

		Postare postare = postareService.creazaPostare(mesaj);
		return postare;
	}
	
	@GetMapping(path="/all")
	public List<Postare> getAllPosts() {
		return postareService.findAll();
	}
	
	@GetMapping(path="/all/{idPostare}")
	public Postare getPostareById(@PathVariable int idPostare) {
		return postareService.findById(idPostare);
	}
	
	@DeleteMapping(path="/all/{postareId}")
	public void deletePostareById(@PathVariable int postareId) {
		postareService.deleteById(postareId);
	}

	@GetMapping(path="all/addCategory/{idPostare}/{categorieId}")
	public void addCategorie(@PathVariable int idPostare, @PathVariable int categorieId){
		postareService.adaugaCategorieLaPostare(idPostare, categorieId);
	}
}
