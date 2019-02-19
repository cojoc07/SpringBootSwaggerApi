package com.stefan.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefan.info.model.Comanda;

public interface ComandaRepository extends JpaRepository<Comanda, Integer> {

}
