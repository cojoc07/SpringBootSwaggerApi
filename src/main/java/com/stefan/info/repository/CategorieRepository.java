package com.stefan.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefan.info.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
