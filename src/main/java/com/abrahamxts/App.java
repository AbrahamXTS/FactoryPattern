package com.abrahamxts;

/**
 * Hello world!
 *
 */
import java.sql.SQLException;
import java.util.List;
import com.abrahamxts.dao.ProductDAO;
import com.abrahamxts.models.Product;

public class App {

    public static void main(String[] args) throws SQLException {
	
        Product productA = new Product(1L, "Product A", 100);
        Product productB = new Product(2L, "Product B", 100);
        
        ProductDAO productDAO = new ProductDAO();
        
        productDAO.saveProduct(productA);
        productDAO.saveProduct(productB);
        
        List<Product> products = productDAO.findAllProducts();

        System.out.println("Product size ==> " + products.size());
		
        for(Product product : products){
            System.out.println(product);
        }
    }
}