package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	// DB接続用URL
	public static Connection getConnect() throws SQLException {
		String host = "localhost";
		String dbname = "attendance_management";
		String user = "root";
		String pw = "abcd";				// 滝本
//		String pw = "ja0007ks";			// 大滝
		String url = "jdbc:mysql://" + host + "/" + dbname + "";
		return (DriverManager.getConnection(url, user, pw));
	}

	// DB接続処理
	public static Connection con() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver").newInstance(); 		// ドライバをロード
		con = DBConnect.getConnect(); 								// MySQLにコネクト
		return (con);
	}
}