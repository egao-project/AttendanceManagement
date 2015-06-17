import java.util.HashSet;
import java.util.Set;

public class Sample34_7 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Set hs = new HashSet();

		hs.add(new String("あいうえお"));
		hs.add(new String("かきくけこ"));
		hs.add(new String("さしすせそ"));
		hs.add(new String("たちつてと"));
		hs.add(new String("たちつてと")); // 同じものを2度追加
		hs.add(new String("なにぬねの"));

		System.out.println(hs);

		for (Object o : hs) {
			System.out.println(o);
		}
	}

}
