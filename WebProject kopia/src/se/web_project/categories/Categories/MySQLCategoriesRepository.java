package se.web_project.categories.Categories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.sql.*;

import se.web_project.Data.DatabaseConnection;


public class MySQLCategoriesRepository implements CategoriesRepository {

	private Map<Integer, Categories> categories;

	public MySQLCategoriesRepository() {
		categories = new HashMap<>();
	}

	@Override
	public void createCategories(Categories categories) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);

			String query = "INSERT INTO categories (id, cat_name, boss_id)"
					+ " VALUES(?,?,?)";

			// pstmt = conn.prepareStatement(query, ResultSet.CONCUR_UPDATABLE);
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, categories.getCategoryId());
			pstmt.setString(2, categories.getCategoryName());
			pstmt.setString(3, categories.getStaffId());

			pstmt.executeUpdate();

			// rs = pstmt.getGeneratedKeys();
			//
			// rs.next();
			//
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
	public void updateCategories(Categories categories) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);
			String query = "UPDATE  categories SET  cat_name=?, boss_id=?" + "WHERE id= ?";
			pstmt = conn.prepareStatement(query);
			//pstmt = conn.prepareStatement(query, ResultSet.CONCUR_UPDATABLE);

			pstmt.setInt(3, categories.getCategoryId());
			pstmt.setString(1, categories.getCategoryName());
			pstmt.setString(2, categories.getStaffId());
			
			pstmt.executeUpdate();
			
			int rows = pstmt.executeUpdate();
			System.out.println("Rows impacted : " + rows);
			pstmt.executeUpdate();
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
	public void deleteCategories(int id) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);

			String query = "DELETE FROM categories WHERE id = ?";

			// pstmt = conn.prepareStatement(query, ResultSet.CONCUR_UPDATABLE);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			// pstmt.executeUpdate();

			pstmt.execute();
			conn.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
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
	public String getAllCategories() {
		String categoryInfo = "";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT * FROM products)";
			pstmt = conn.prepareStatement(query, ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery(query);

			for (Entry<Integer, Categories> categoryList : categories.entrySet()) {
				categories.keySet();
				System.out.println(categoryList.toString());
			}
			if (categories.size() == 0) {
				throw new SQLException("You dont have any products to show");
			}
			for (Categories c : categories.values()) {
				categoryInfo = "------------------------------------------\n";
				categoryInfo += c;
				categoryInfo += "------------------------------------------\n\n";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
		return categoryInfo;
	}

	@Override
	public Categories getCategories(int id) {
		if (categories.containsKey(id)) {
			return categories.get(id);
		} else {
			return null;
		}
	}
}