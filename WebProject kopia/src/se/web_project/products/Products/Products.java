package se.web_project.products.Products;

public class Products {
	private int productId;
	private String productName;
	private String description;
	private double cost = 0;
	private double rrp = 0;

	public Products(int id) {
		this.productId = id;
		this.setProductName("");
		this.setDescription("");
		this.getCost();
		this.getRrp();
	}
	public Products() {
		this.productId = 0;
		this.setProductName("");
		this.setDescription("");
		this.getCost();
		this.getRrp();
	}

	public int getProductId() {
		return this.productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getRrp() {
		return this.rrp;
	}

	public void setRrp(double rrp) {
		this.rrp = rrp;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		Products prodTemp = null;

		if (obj instanceof Products) {
			prodTemp = (Products) obj;
		}

		return (this.productId == prodTemp.productId);
	}

	@Override
	public int hashCode() {
		return 37 * this.productId;
	}

	@Override
	public String toString() {
		return String.format("ProductId: %s, ProductName: %s, Description: %s, Cost: %s, RRP: %s .  \n",
						productId, productName, description, cost, rrp);
	}
	public void setProductId(int id) {
		this.productId = productId;
	}
}
