package com.stefan.info.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategorieRequestRepresentation {

    @JsonIgnore
    private int id;

    @JsonProperty
    private String denumire;

    private CategorieRequestRepresentation(int id, String denumire) {
        this.id = id;
        this.denumire = denumire;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
