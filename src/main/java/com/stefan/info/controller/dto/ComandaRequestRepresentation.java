package com.stefan.info.controller.dto;

import com.stefan.info.model.Factura;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ComandaRequestRepresentation {

    @JsonIgnore
    private int id;
    @JsonProperty
    private float suma;
    @JsonProperty
    private int user;
    @JsonIgnore
    private Factura factura;
    @JsonProperty
    private String descriere;

    public ComandaRequestRepresentation(int id, float suma, int user, Factura factura, String descriere) {
        this.id = id;
        this.suma = suma;
        this.user = user;
        this.factura = factura;
        this.descriere = descriere;
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

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
}
