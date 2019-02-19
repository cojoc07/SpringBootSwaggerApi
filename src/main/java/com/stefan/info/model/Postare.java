package com.stefan.info.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "postari")
public class Postare {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "postat_pe")
    private Date postatPe = new Date();
	
	@ManyToMany(fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	@JoinTable(name = "post_cat",
	           joinColumns = { @JoinColumn(name = "postare_id") },
	           inverseJoinColumns = { @JoinColumn(name = "categorie_id") })
	private Set<Categorie> categorii = new HashSet<>();

	public void adaugaCategorieLaPostare(Categorie categorie){
		Set<Categorie> list = getCategorii();
		list.add(categorie);
		setCategorii(list);
	}

	private String mesaj;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPostatPe() {
		return postatPe;
	}

	public void setPostatPe(Date postatPe) {
		this.postatPe = postatPe;
	}

	public Set<Categorie> getCategorii() {
		return categorii;
	}

	public void setCategorii(Set<Categorie> categorii) {
		this.categorii = categorii;
	}

	public String getMesaj() {
		return mesaj;
	}

	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	
	
}
