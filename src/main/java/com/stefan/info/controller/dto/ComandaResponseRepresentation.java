package com.stefan.info.controller.dto;

import com.stefan.info.model.Comanda;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComandaResponseRepresentation {

    @JsonProperty
    private int id;
    @JsonProperty
    private float suma;
    @JsonProperty
    private UserResponseRepresentation user;
    @JsonProperty
    private FacturaResponseRepresentation factura;
    @JsonProperty
    private String descriere;

    public static ComandaResponseRepresentation convertFaraFactura(Comanda comanda) {
        return new ComandaResponseRepresentation(comanda.getId(),
                comanda.getSuma(), UserResponseRepresentation.convert(comanda.getUser()),
                null, comanda.getDescriere()
        );
    }

    public static ComandaResponseRepresentation convert(Comanda comanda) {
        return new ComandaResponseRepresentation(comanda.getId(),
                comanda.getSuma(), UserResponseRepresentation.convert(comanda.getUser()),
                FacturaResponseRepresentation.convert(comanda.getFactura()), comanda.getDescriere()
        );
    }

    private ComandaResponseRepresentation(int id,
                                          float suma,
                                          UserResponseRepresentation user,
                                          FacturaResponseRepresentation factura,
                                          String descriere) {
        this.id = id;
        this.suma = suma;
        this.user = user;
        this.factura = factura;
        this.descriere = descriere;
    }
}
