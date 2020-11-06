package com.gama.passagens.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.gama.passagens.project.model.reserva.Reserva;

public interface ReservaRepository extends CrudRepository<Reserva, Integer> {

}
