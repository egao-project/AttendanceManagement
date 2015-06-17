import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBSample2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String host = "localhost";
		String port = "1521";
		String dbname = "XE";
		String user = "SYSTEM";
		String pwd = "abc";
		String url = "jdbc:oracle:thin:@" + host + ":" + port + "/" + dbname;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT * FROM tb1 WHERE col3 >= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 30);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2)
						+ "\t" + rs.getInt(3));
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
					pstmt.close();
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
