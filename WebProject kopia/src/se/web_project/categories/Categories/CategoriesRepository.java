package se.web_project.categories.Categories;


public interface CategoriesRepository {

	public void createCategories(Categories categories);

	public void updateCategories(Categories categories);

	public void deleteCategories(int id);
	
	public Categories getCategories(int id);
	
	public String getAllCategories();
}
