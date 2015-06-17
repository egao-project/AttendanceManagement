import java.util.Date;

public class Testtest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//ミリ秒を出す
		Date Now = new Date();
		int Time = ((int) Now.getTime());

		//取得したミリ秒から下一桁を取得
		int a = Time % 10;

		System.out.println(a);

	}

}
