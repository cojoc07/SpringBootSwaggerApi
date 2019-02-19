package com.stefan.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefan.info.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {

}
