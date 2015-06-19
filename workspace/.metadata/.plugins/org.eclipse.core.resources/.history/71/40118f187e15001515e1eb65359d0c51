package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public static Connection getConnect() throws SQLException {
		String host = "localhost";
		String port = "3306";
		String dbname = "attendance_management";
		String user = "local";
		String pw = "abcd";
		String url = "jdbc:mysql://" + host + "/" + dbname + "\"";
		return (DriverManager.getConnection(url, user, pw));
	}

}
