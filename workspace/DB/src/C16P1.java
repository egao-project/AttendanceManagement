import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C16P1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String host = "localhost";
		String port = "1521";
		String dbname = "XE";
		String user = "SYSTEM";
		String pwd = "abc";
		String url = "jdbc:oracle:thin:@" + host + ":" + port + "/" + dbname;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();
			String sql = "SELECT col1,col_d FROM tb2";

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("col1") + "\t"
						+ rs.getString("col_d"));
			}
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}
			try {
				if (rs != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}
			try {
				if (rs != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}
		}

	}

}
