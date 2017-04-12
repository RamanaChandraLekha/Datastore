package com.shoppingCart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.full.model.Main;
import com.full.model.Product;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class ViewProductsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Main productsPresent = new Main();
		ArrayList<String> productId=new ArrayList<String>();
		ArrayList<String> product=new ArrayList<String>();
		ArrayList<Integer> quantity=new ArrayList<Integer>();
		

		HashMap<String, ArrayList<Product>> products = productsPresent.display();
		
	/*	Set<Map.Entry<String, ArrayList<Product>>> productsSet = products.entrySet();
		Iterator iter = productsSet.iterator();
		Product prod;
		while (iter.hasNext()) {

			Map.Entry entry = (Map.Entry) iter.next();
			// = (String) entry.getKey();
			ArrayList<Product> productsAvailable = (ArrayList<Product>) entry.getValue();

			Iterator<Product> iterateProducts =  productsAvailable.iterator();
			while (iterateProducts.hasNext()) {

				prod = iterateProducts.next();
				productId.add(prod.getId());
				product.add(prod.getProductName());
			    quantity.add(prod.getQuantity());
			                                                
				
                                                            		}
		}

		JSONArray id = new JSONArray(productId);
		JSONArray productsList = new JSONArray(product);
		JSONArray availableQuantity = new JSONArray(quantity);
*/		JSONObject jobj = new JSONObject(products);
		//String lists = "["+id+","+productsList+","+availableQuantity+"]";
	//String lists={id,productsList,availableQuantity};
        PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(jobj);
	
	}

}
