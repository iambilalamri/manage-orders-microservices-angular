package com.amrib.ecom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private String productId;
	private String name;
	private String code;
	private String title;
	private String description;
	private String imgURL;
	private Double price;

}
