import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C16P1a {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "SELECT * FROM tb2";

		try (Connection con = DBConnect.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				System.out.println(rs.getString("col1") + "\t"
						+ rs.getString("col_d") + "\t" + rs.getString("col_m"));
			}

		} catch (SQLException e) {
			System.err.println(e);
		}

	}

}
