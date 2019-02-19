package com.stefan.info.controller;

import com.stefan.info.controller.dto.CategorieRequestRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stefan.info.model.Categorie;
import com.stefan.info.service.CategorieService;

import java.util.List;

@RestController    
@RequestMapping(path="/categorii") 
public class CategorieController {
	
	@Autowired
	private CategorieService categorieService;
	
	@GetMapping(path="/add")
	public Categorie addNewCategorie (@RequestParam String denumire) {

		Categorie categorie = categorieService.adaugaCategorie(denumire);
		return categorie;
	}
	
	@GetMapping(path="/all")
	public List<Categorie> getAllCategorii() {
		return categorieService.findAll();
	}
	
	@GetMapping(path="/all/{categorieId}")
	public Categorie getCategorieById(@PathVariable int categorieId) {
		return categorieService.findById(categorieId);
	}
	
	@DeleteMapping(path="/all/{categorieId}")
	public void deleteCategorieById(@PathVariable int categorieId) {
		categorieService.deleteById(categorieId);
	}

	@PutMapping(path="all/{id_categorie}")
	public Categorie update(@PathVariable int id_categorie, @RequestBody CategorieRequestRepresentation categorie) {
		Categorie nou = categorieService.findById(id_categorie);

		nou.setDenumire(categorie.getDenumire());
		nou.setId(id_categorie);
		nou.setPosts(null);
		categorieService.save(nou);
		return nou;
	}

	@PostMapping(path="all/addCategorie")
	public Categorie postCreate(@RequestBody CategorieRequestRepresentation categorie) {
		Categorie nou = new Categorie();

		nou.setDenumire(categorie.getDenumire());

		categorieService.save(nou);
		return nou;
	}

}
