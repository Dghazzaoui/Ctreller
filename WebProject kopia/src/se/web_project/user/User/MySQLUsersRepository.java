package se.web_project.user.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.sql.*;

import se.web_project.Data.DatabaseConnection;
import se.web_project.categories.Categories.Categories;

public class MySQLUsersRepository implements UsersRepository {

	private static final int[] autoGeneratedKeys = null;
	private Map<Integer, User> users;

//	public MySQLUsersRepository() {
//		users = new HashMap<>();
//	}

	@Override
	public void createUser(User user) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);

			String query = "INSERT INTO users (firstname,lastname,username, password,street_address,city, postcode,telephone_number)"
					+ "VALUES(?,?,?,?,?,?,?,?);";

			// pstmt = conn.prepareStatement(query, ResultSet.CONCUR_UPDATABLE);
			pstmt = conn.prepareStatement(query);
			// pstmt =
			// conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			//pstmt.setInt(1, user.getUserId());
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getEMail());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getStreetAddress());
			pstmt.setString(6, user.getCity());
			pstmt.setString(7, user.getPostcode());
			pstmt.setString(8, user.getPhoneNumber());

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
	public void deleteUser(int id) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);

			String query = "DELETE FROM users WHERE id = ?";

			//pstmt = conn.prepareStatement(query, ResultSet.CONCUR_UPDATABLE);
			pstmt = conn.prepareStatement(query);
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
	public void updateUser(User user) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);
			String query = "UPDATE  users SET firstName=?, lastName=?,username=?, password=?, street_address=?, city=?, postcode=?, telephone_number=?" + "WHERE id =?";
			//pstmt = conn.prepareStatement(query, ResultSet.CONCUR_UPDATABLE);
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getEMail());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getStreetAddress());
			pstmt.setString(6, user.getCity());
			pstmt.setString(7, user.getPostcode());
			pstmt.setString(8, user.getPhoneNumber());
			pstmt.setInt(9, user.getUserId());
			
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

	private List<User> userList;
	
	public MySQLUsersRepository() {
		userList = new ArrayList<User>();
		
	}
	
	@Override
	public List<User> getAllUsers() {
		//String userInfo = "";
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT * FROM users";
			//stmt = conn.createStatement(ResultSet.CONCUR_UPDATABLE);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setEMail(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setStreetAddress(rs.getString("street_address"));
				user.setCity(rs.getString("city"));
				user.setPostcode(rs.getString("postcode"));
				user.setPhoneNumber(rs.getString("telephone_number"));
				userList.add(user);
				
			}
			
//			for (Entry<Integer, User> userList : users.entrySet()) {
//				users.keySet();
//				System.out.println(userList.toString());
//			}
//			if (users.size() == 0) {
//				throw new SQLException("You don't have any users to show");
//			}
//
//			for (User u : users.values()) {
//				userInfo += "------------------------------------------\n";
//				userInfo += u;
//				userInfo += "------------------------------------------\n\n";
//				
//				
//			}
			
			conn.commit();
			
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
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}

	@Override
	public User getUser(int id) {
		if (users.containsKey(id)) {
			return users.get(id);
		} else {
			return null;
		}
	}
}
