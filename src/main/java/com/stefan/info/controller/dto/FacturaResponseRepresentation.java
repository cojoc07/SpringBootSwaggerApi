package com.stefan.info.controller.dto;

import com.stefan.info.model.Factura;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FacturaResponseRepresentation {

    @JsonProperty
    private int id;
    @JsonProperty
    private Float suma;
    @JsonProperty
    private ComandaResponseRepresentation comanda;

    public static FacturaResponseRepresentation convert(Factura factura){

        return new FacturaResponseRepresentation(factura.getId(),
                factura.getSuma(),
                ComandaResponseRepresentation.convertFaraFactura(factura.getComanda())
        );

    }

    public static FacturaResponseRepresentation convertFaraComanda(Factura factura){

        return new FacturaResponseRepresentation(factura.getId(),
                factura.getSuma(),
                null
        );

    }

    private FacturaResponseRepresentation(int id, Float suma, ComandaResponseRepresentation comanda) {
        this.id = id;
        this.suma = suma;
        this.comanda = comanda;
    }
}
