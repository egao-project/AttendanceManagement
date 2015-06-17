import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSample4 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "INSERT INTO tb1 VALUES('E99','永山',38)";

		try (Connection con = DBConnect.getConnect();
				Statement stmt = con.createStatement()) {
			int count = stmt.executeUpdate(sql);
			System.out.println("更新件数" + count);
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

}
