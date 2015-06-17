import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C16P3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "UPDATE tb2 SET col_d = 199 WHERE col1 = 'J01'";

		try (Connection con = DBConnect.getConnect();
				Statement stmt = con.createStatement()) {
			int count = stmt.executeUpdate(sql);
			System.out.println("更新件数" + count);
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

}
