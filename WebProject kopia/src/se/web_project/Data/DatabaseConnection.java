package se.web_project.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {
		String jdbcDriver = "com.mysql.jdbc.Driver";
		String dburl = "jdbc:mysql://localhost/floggit";
		String username = "j.s.bach";
		String pass = "Annie78";
		Class.forName(jdbcDriver);
		Connection conn = DriverManager.getConnection(dburl, username, pass);
		return conn;
	}
}
