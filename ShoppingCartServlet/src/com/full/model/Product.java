package com.full.model;


import java.util.HashMap;

public class Product {
	static HashMap<String, Integer> productWithId = new HashMap<String, Integer>();
	public String productName;
	public int quantity;
	public String id;

	String shopKeeperId;

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product(String id, String productName, int quantity) {
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;

	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public String toString() {
		return  "["+id +","+ productName + "," + quantity+"]";
	}

}
