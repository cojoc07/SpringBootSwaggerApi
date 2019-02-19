package com.stefan.info.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "comenzi")
public class Comanda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private float suma;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private User user;
	
	@OneToOne(cascade =  CascadeType.ALL,
			mappedBy = "comanda")
	private Factura factura;
	
	private String descriere;
	
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getSuma() {
		return suma;
	}
	public void setSuma(float suma) {
		this.suma = suma;
	}
}
