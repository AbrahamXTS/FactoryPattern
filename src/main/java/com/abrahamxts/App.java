package com.abrahamxts;

import java.util.List;
import java.sql.SQLException;

import com.abrahamxts.DAO.ProductDAO;
import com.abrahamxts.models.Product;

public class App {

    public static void main(String[] args) throws SQLException {

		// Crea tu producto con el constructor aquí
		
	
        ProductDAO productDAO = new ProductDAO();
        
		// Pasa tu producto a esta función para guardarlo dentro de la base de datos.
        productDAO.saveProduct();
        
        List<Product> products = productDAO.findAllProducts();

        System.out.println("Total de productos ==> " + products.size());
		
		// Listando todos los productos de la base de datos.
        for (Product product : products){
            System.out.println(product);
        }
    }
}