import java.util.HashSet;
import java.util.Set;

public class Sample34_7A {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Set hs = new HashSet();

		hs.add(new StringBuilder("あいうえお"));
		hs.add(new StringBuilder("かきくけこ"));
		hs.add(new StringBuilder("さしすせそ"));
		hs.add(new StringBuilder("たちつてと"));
		hs.add(new StringBuilder("たちつてと")); // 同じものを2度追加
		hs.add(new StringBuilder("なにぬねの"));

		System.out.println(hs);

		for (Object o : hs) {
			System.out.println(o);
		}
	}

}
