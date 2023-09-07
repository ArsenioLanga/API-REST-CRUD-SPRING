package com.place.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.place.apirest.domain.transation.Transation;

public interface TransationRepository extends JpaRepository<Transation, Long>{

}
