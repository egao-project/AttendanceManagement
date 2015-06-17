import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSample3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "SELECT col2 FROM tb1 WHERE col3 >= 30";

		try (Connection con = DBConnect.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				System.out.println(rs.getString("col2"));
			}

		} catch (SQLException e) {
			System.err.println(e);
		}
	}

}
