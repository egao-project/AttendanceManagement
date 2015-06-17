import java.util.SortedSet;
import java.util.TreeSet;

public class Sample34_9 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		SortedSet ts = new TreeSet();

		ts.add("たちつてと");
		ts.add("かきくけこ");
		ts.add("さしすせそ");
		ts.add("なにぬねの");
		ts.add("あいうえお");

		System.out.println("all" + ts);
		System.out.println("first:" + ts.first());
		System.out.println("last:" + ts.last());
		SortedSet sub = ts.subSet("かきくけこ", "たちつてと");
		System.out.println("subset" + sub);
		SortedSet head = ts.headSet("さしすせそ");
		System.out.println("head" + head);
		SortedSet tail = ts.tailSet("さしすせそ");
		System.out.println("tail" + tail);
	}
}