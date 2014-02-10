package se.web_project.eCommerceService.ECommerceService;

import java.util.List;

import se.web_project.SQLException.SQLException;
import se.web_project.categories.Categories.Categories;
import se.web_project.categories.Categories.CategoriesRepository;
import se.web_project.products.Products.Products;
import se.web_project.products.Products.ProductsRepository;
import se.web_project.user.User.*;

public class ECommerceService implements UsersRepository, ProductsRepository,
		CategoriesRepository {
	private UsersRepository usersRepository;
	private ProductsRepository productsRepository;
	private CategoriesRepository categoriesRepository;

	public ECommerceService(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	public ECommerceService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public ECommerceService(CategoriesRepository categoriesRepository) {
		this.categoriesRepository = categoriesRepository;
	}

	// ******************************************
	@Override
	public void deleteUser(int id) {
		usersRepository.deleteUser(id);
	}

	@Override
	public void updateUser(User user) {
		usersRepository.updateUser(user);

	}

	@Override
	public void createUser(User user) {
		usersRepository.createUser(user);

	}

	@Override
	public List<User> getAllUsers() {
	     return usersRepository.getAllUsers();
		
	}

	@Override
	public User getUser(int id) {
		return usersRepository.getUser(id);
	}

	// ******************************************

	@Override
	public Products getProduct(int id) {
		return productsRepository.getProduct(id);
	}

	@Override
	public void createProduct(Products products) {
		productsRepository.createProduct(products);

	}

	@Override
	public void deleteProduct(int id) {
		productsRepository.deleteProduct(id);

	}

	@Override
	public void updateProduct(Products products) {
		productsRepository.updateProduct(products);

	}
	
	@Override
	public String getAllProducts() {
		return productsRepository.getAllProducts();

	}

//	@Override
//	public List<Products> getAllProducts() {
//		return productsRepository.getAllProducts();
//
//	}

	// *******************************************************

	@Override
	public void deleteCategories(int id) {
		categoriesRepository.deleteCategories(id);

	}

	@Override
	public Categories getCategories(int id) {
		return categoriesRepository.getCategories(id);
	}

	@Override
	public String getAllCategories() {
		return categoriesRepository.getAllCategories();
	}

	@Override
	public void createCategories(Categories categories) {
		categoriesRepository.createCategories(categories);
	}

	@Override
	public void updateCategories(Categories categories) {
		categoriesRepository.updateCategories(categories);

	}

}