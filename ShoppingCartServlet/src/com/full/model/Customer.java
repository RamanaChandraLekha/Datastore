package com.full.model;

import java.util.ArrayList;

import java.util.HashMap;

public class Customer {
	public static HashMap<String,ArrayList<Product>> customerProducts=new HashMap<String,ArrayList<Product>>();
	String customerName;

	ArrayList<Product> products;

	Customer( ArrayList<Product> products) {

		
		this.products = products;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String toString() {
		return  products.toString();
	}
}
