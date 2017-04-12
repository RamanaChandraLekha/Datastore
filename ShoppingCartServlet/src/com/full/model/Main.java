package com.full.model;
import java.util.ArrayList;
import java.util.HashMap;



public class Main {

	public static HashMap<String,ArrayList<Product>> totalProducts=new  HashMap<String,ArrayList<Product>>();
public  HashMap<String,ArrayList<Product>> display()
{
	//System.out.println(totalProducts);
	return  totalProducts;
	
}
public static HashMap<String,ArrayList<Product>> returnProducts()
{
	return totalProducts;
}
public static void addProducts(String ShopkeeperId, ArrayList<Product> products)
{
	totalProducts.put(ShopkeeperId,products);
}

}
