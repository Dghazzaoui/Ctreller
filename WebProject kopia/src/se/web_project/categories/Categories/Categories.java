package se.web_project.categories.Categories;

public class Categories {

	private int categoryId;
	private String staffId;
	private String categoryName;

	public Categories(int id) {
		this.categoryId = id;
		this.setStaffId("");
		this.setCategoryName("");

	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoriId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getStaffId() {
		return this.staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		Categories categoryTemp = null;

		if (obj instanceof Categories) {
			categoryTemp = (Categories) obj;
		}

		return (this.categoryId == categoryTemp.categoryId || this.categoryName
				.equals(categoryTemp.categoryName));

	}

	@Override
	public int hashCode() {
		int result = 1;
		result += 37 * this.categoryId;
		//result += 37 * this.staffId;
		result += 37 * this.categoryName.hashCode();

		return result;
	}

	@Override
	public String toString() {
		String categoryInfo = "";

		categoryInfo += "categoryId: " + this.categoryId + "\n";
		//categoryInfo += "staffId: " + this.staffId + "\n";
		categoryInfo += "categoryName: " + this.categoryName + "\n";

		return categoryInfo;
	}
}