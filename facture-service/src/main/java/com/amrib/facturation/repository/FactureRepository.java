package com.amrib.facturation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.amrib.facturation.model.Facture;

@RepositoryRestResource
public interface FactureRepository extends JpaRepository<Facture, Long> {

}
