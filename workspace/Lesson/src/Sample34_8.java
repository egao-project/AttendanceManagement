import java.util.LinkedHashSet;
import java.util.Set;

public class Sample34_8 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Set hs = new LinkedHashSet();

		hs.add("あいうえお");
		hs.add("かきくけこ");
		hs.add("さしすせそ");
		hs.add("たちつてと");
		hs.add("なにぬねの");

		System.out.println(hs);

		for (Object o : hs) {
			System.out.println(o);
		}
	}

}
