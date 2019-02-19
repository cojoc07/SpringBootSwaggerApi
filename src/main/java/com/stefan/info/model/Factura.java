package com.stefan.info.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "facturi")
public class Factura {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Float suma;
	
	@OneToOne
	@JoinColumn(name = "comanda_id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Comanda comanda;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Float getSuma() {
		return suma;
	}

	public void setSuma(Float suma) {
		this.suma = suma;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}
	
	
}
