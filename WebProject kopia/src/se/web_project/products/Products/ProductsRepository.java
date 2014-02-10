package se.web_project.products.Products;

import java.util.List;

import se.web_project.user.User.User;

public interface ProductsRepository {

	public void createProduct(Products products);

	public void updateProduct(Products products);

	public void deleteProduct(int id);

	//public List<Products> getAllProducts();
	
	public List<User> getAllProducts();

	// public int createProduct(int Id);

	public Products getProduct(int id);

}
