package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public static Connection getConnect() throws SQLException {
		String host = "localhost";
		String dbname = "attendance_management";
		String user = "root";
		String pw = "abcd";
		String url = "jdbc:mysql://" + host + "/" + dbname;
		return (DriverManager.getConnection(url, user, pw));
	}

}
