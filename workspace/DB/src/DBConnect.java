import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public static Connection getConnect() throws SQLException {
		String host = "localhost";
		String port = "1521";
		String dbname = "XE";
		String user = "SYSTEM";
		String pw = "abc";
		String url = "jdbc:oracle:thin:@" + host + ":" + port + "/" + dbname;
		return (DriverManager.getConnection(url, user, pw));
	}

}
