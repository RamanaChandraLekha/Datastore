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

public class DeleteProductsServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		int flag = 0;

		Product product;
		ArrayList<Product> productObjects;
		out.println(Main.totalProducts);
		String shopkeeperId = request.getParameter("shopkeeperid");
		String productId = request.getParameter("productid");

		if (Main.totalProducts.containsKey(shopkeeperId)) {
			productObjects = Main.totalProducts.get(shopkeeperId);
			Iterator<Product> iterator = productObjects.iterator();
			while (iterator.hasNext()) {

				product = iterator.next();
				if (product.id.equals(productId)) {
					iterator.remove();
					flag = 1;

				}
			}
			if (flag == 0)
				out.println("such id is not present");
		} else
			out.println("shopkeeperid is not valid");
		out.println("<br><html><body><a href='Shopkeeper.html'>Click for menu</a></body></html>");
	}

}
