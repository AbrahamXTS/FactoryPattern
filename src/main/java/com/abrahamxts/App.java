package com.abrahamxts;

import java.util.List;
import java.sql.SQLException;

import com.abrahamxts.DAO.ProductDAO;
import com.abrahamxts.models.Product;

public class App {

    public static void main(String[] args) throws SQLException {
	
        Product productA = new Product(1L, "Producto A", 100);
        Product productB = new Product(2L, "Producto B", 100);
        
        ProductDAO productDAO = new ProductDAO();
        
        productDAO.saveProduct(productA);
        productDAO.saveProduct(productB);
        
        List<Product> products = productDAO.findAllProducts();

        System.out.println("Product size ==> " + products.size());
		
        for (Product product : products){
            System.out.println(product);
        }
    }
}