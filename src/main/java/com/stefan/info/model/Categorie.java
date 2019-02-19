package com.stefan.info.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorii")
public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String denumire;
	
	@ManyToMany(mappedBy = "categorii") //field-ul de dincolo
    private Set<Postare> posts = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public Set<Postare> getPosts() {
		return posts;
	}

	public void setPosts(Set<Postare> posts) {
		this.posts = posts;
	}
	
	
}
