package com.shoppingCart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.full.model.Main;
import com.full.model.Product;

public class RetrieveProductsServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Product product;
		ArrayList<Product> productObjects;
		String shopkeeperId, productId;
		int flag = 0;
		int id;

		shopkeeperId = request.getParameter("shopkeeperid");
		productId = request.getParameter("productid");

		try {
			productObjects = Main.totalProducts.get(shopkeeperId);
			Iterator<Product> iterator = productObjects.iterator();
			while (iterator.hasNext()) {
				product = iterator.next();
				if (product.id.equals(productId)) {
					out.println("id of the product is " + product.getId());
					out.println("name of the product is" + product.getProductName());
					out.println("quantity of the product is" + product.getQuantity());
					flag = 1;
				}
			}
		} catch (Exception e) {
			out.println("no products available");
		}
		if (flag == 0)
			out.println("such id is not present");

		out.println("<br><html><body><a href='Shopkeeper.html'>Click for menu</a></body></html>");

	}

}
