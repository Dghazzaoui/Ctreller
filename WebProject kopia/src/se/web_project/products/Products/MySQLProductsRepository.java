package se.web_project.products.Products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.sql.*;

import se.web_project.Data.DatabaseConnection;

public class MySQLProductsRepository<Product> implements ProductsRepository {
	private Map<Integer, Products> products;

	public MySQLProductsRepository() {
		products = new HashMap<>();
	}

	@Override
	public void createProduct(Products products) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);

			String query = "INSERT INTO products (id, product_name, description, cost, RRP)"
					+ "VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			// pstmt = conn.prepareStatement(query, ResultSet.CONCUR_UPDATABLE);

			pstmt.setInt(1, products.getProductId());
			pstmt.setString(2, products.getProductName());
			pstmt.setString(3, products.getDescription());
			pstmt.setDouble(4, products.getCost());
			pstmt.setDouble(5, products.getRrp());

			pstmt.executeUpdate();
			// rs = pstmt.getGeneratedKeys();
			// rs.next();
			// int id = rs.getInt(1);
			// user.getUserId(); // not sure if this is the best way to return
			// the id.

			conn.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateProduct(Products products) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);
			String query = "UPDATE  products SET product_name=?, description=? ,cost=?, RRP=?"
					+ "WHERE id=?";

			pstmt = conn.prepareStatement(query);
			//pstmt = conn.prepareStatement(query, ResultSet.CONCUR_UPDATABLE);

			pstmt.setInt(5, products.getProductId());
			pstmt.setString(1, products.getProductName());
			pstmt.setString(2, products.getDescription());
			pstmt.setDouble(3, products.getCost());
			pstmt.setDouble(4, products.getRrp());

			pstmt.executeUpdate();

			int rows = pstmt.executeUpdate();
			System.out.println("Rows impacted : " + rows);
			// pstmt.executeUpdate();
			conn.commit();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteProduct(int id) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);

			String query = "DELETE FROM products WHERE id =?";

			pstmt = conn.prepareStatement(query, ResultSet.CONCUR_UPDATABLE);
			pstmt = conn.prepareStatement(query);

			// kolla med User
			pstmt.setInt(1, id);
			pstmt.execute();

			conn.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getAllProducts() {
		String productInfo = "";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//String products;

		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT * FROM products)";
			//pstmt = conn.prepareStatement(query, ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery(query);

			for (Entry<Integer, Products> productList : products.entrySet()) {
				products.keySet();
				System.out.println(productList.toString());
			}
			if (products.size() == 0) {
				throw new SQLException("You dont have any products to show");
			}
			for (Products p : products.values()) {
				productInfo = "------------------------------------------\n";
				productInfo += p;
				productInfo += "------------------------------------------\n\n";
			}


			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productInfo;

		
	} // End of getAllProducts

	

	@Override
	public Products getProduct(int id) {
		if (products.containsKey(id)) {
			return products.get(id);
		} else {
			return null;
		}
	}

}
