package dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import product.Product;

/* In your root SGBDR (MySQL):
 * 
 * CREATE USER 'yann'@'localhost' IDENTIFIED BY 'yann';
 * GRANT ALL PRIVILEGES ON homeshop.* TO 'yann'@'localhost';
 * 
 * CREATE DATABASE homeshop;
 * USE homeshop; 
 * 
 * SOURCE C:/..../Ressource/StoreManager.sql;
 */

/* Warning, several SQLException might come according to the MySQL version:
 * 
 * Number 1: Unable to load authentication plugin 'caching_sha2_password'.
 *           Note: Starting with MySQL 8.0.4, they have changed the default authentication plugin for MySQL server 
 *                 from mysql_native_password to caching_sha2_password.
 *                 
 * ALTER USER 'yann'@'localhost' IDENTIFIED WITH mysql_native_password BY 'yann';
 *
 * Number 2: The server time zone value 'Paris, Madrid' is unrecognized or represents more than one time zone. 
 *           You must configure either the server or JDBC driver (via the serverTimezone configuration property) 
 *           to use a more specifc time zone value if you want to utilize time zone support.
 *           
 * SET GLOBAL time_zone = '+3:00';
 */

public class ProductDAO {
	
	/**
	 * Gets all products on database
	 * @return an List<Product> object that contains all products on database
	 */
	public List<Product> getAll() {		
		
		// products is the List<Product> that will be returned in this method
	    List<Product> products = new ArrayList<>();

	    try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	    
	    try {
	        Connection connection = DriverManager.getConnection(this.url, this.user, this.pwd);

	        // A Statement object creates a query
	        Statement statement = connection.createStatement();
	        
	        // It is a SQL query to display the totality of the content of the product table
	        // SQL: SELECT * FROM product;
	        ResultSet rs = statement.executeQuery("SELECT * FROM product");

	        // +----+-------+-------------+--------+
	        // |            product                |
	        // +----+-------+-------------+--------+
	        // | id | name  | description | price  |
	        // +----+-------+-------------+--------+
	        while (rs.next()) {
	        	// For each row, the 3 following parameters are recovered
	            String name = rs.getString("name");
	            String description = rs.getString("description");
	            Double price = rs.getDouble("price");

	            products.add(new Product(name, description, price));
	        }

	        connection.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return products;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private String url = "jdbc:mysql://localhost/homeshop";
	private String user = "yann";
	private String pwd = "yann";
}
