package com.amrib.facturation.services;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.amrib.facturation.model.Facture;
import com.amrib.facturation.model.ProductItem;

@Projection(name = "f1", types = { Facture.class, ProductItem.class })
public interface FactureProjection {

	public Long getId();

	public Date getFactureDate();

	public Long getCustomerId();

	public Collection<ProductItem> getProductItems();
}
