import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSample6 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "DELETE FROM tb1 WHERE col1 = 'E99'";

		try (Connection con = DBConnect.getConnect();
				Statement stmt = con.createStatement()) {
			int count = stmt.executeUpdate(sql);
			System.out.println("更新件数" + count);
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

}
