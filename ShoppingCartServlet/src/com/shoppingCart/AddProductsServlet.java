package com.shoppingCart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.full.model.Main;
import com.full.model.Product;

public class AddProductsServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		// String choice = " ";
		String id;
		String shopkeeperId = request.getParameter("shopkeeperId");
		String product = request.getParameter("product");
		String quantity = request.getParameter("quantity");
		int quan = Integer.parseInt(quantity);
		ArrayList<Product> products = new ArrayList<Product>();
		id = product + "_" + shopkeeperId;
		Product productObj = new Product(id, product, quan);
		products.add(productObj);
		Main productsPresent = new Main();
		HashMap<String, ArrayList<Product>> totalProducts = Main.returnProducts();
		if (totalProducts.containsKey(shopkeeperId)) {
			ArrayList<Product> productList = Main.totalProducts.get(shopkeeperId);
			products.addAll(productList);

		}

		out.println("Products are" + productObj);

		Main.addProducts(shopkeeperId, products);
		productsPresent.display();
		/*
		 * response.sendRedirect("UsersChhoice.html"); choice =
		 * request.getParameter("choice"); if (choice.equals("yes")) {
		 * response.sendRedirect("AddProduct.html");
		 */
		response.sendRedirect("Shopkeeper.html");
	}

}
