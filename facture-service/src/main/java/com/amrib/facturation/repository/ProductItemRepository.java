package com.amrib.facturation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amrib.facturation.model.ProductItem;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

}
