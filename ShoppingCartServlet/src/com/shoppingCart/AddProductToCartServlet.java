package com.shoppingCart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.full.model.Customer;
import com.full.model.CustomerHelper;
import com.full.model.Product;




public class AddProductToCartServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		ArrayList<Product> customersProducts;
		CustomerHelper customerHelper=new CustomerHelper();
	ArrayList<Product> productsList=new ArrayList<Product>();
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String customerName=request.getParameter("customerName");
		String product=request.getParameter("product");
		String productId=request.getParameter("productId");
		String quan=request.getParameter("quantity");
		int quantity=Integer.parseInt(quan);
		int availabilty=customerHelper.checkForProduct(productId,quantity,product);
		if((availabilty!=0)&&(quantity<=availabilty))
		{
			Product prod = new Product(productId,product,quantity);
			productsList.add(prod);
			if(Customer.customerProducts.containsKey(customerName))
			{
				customersProducts=Customer.customerProducts.get(customerName);
				productsList.addAll(customersProducts);
			}
			Customer.customerProducts.put(customerName,productsList);
			out.println(Customer.customerProducts);
			String shopkeeperId = customerHelper.getShopkeeperId();
			Product productBought = customerHelper.getProduct();
			customerHelper.updatingProductList(shopkeeperId, productBought);

		}
		else if(availabilty==0)
		{
			out.println("such product is not available");
			
		}
		else if(quantity>availabilty)
		{
			out.println("out of stock");
		}
		out.println("<html><body><a href='Customer.html'> click for menu </a></body></html>");
		
	}

}
