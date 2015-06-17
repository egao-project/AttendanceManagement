import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Sample34_10 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		TreeSet ts = new TreeSet();

		ts.add("たちつてと");
		ts.add("かきくけこ");
		ts.add("さしすせそ");
		ts.add("なにぬねの");
		ts.add("あいうえお");

		System.out.println("all" + ts);
		System.out.println("ceil:" + ts.ceiling("さしすせそ"));
		System.out.println("floor:" + ts.floor("さしすせそ"));
		System.out.println("higher:" + ts.higher("さしすせそ"));
		System.out.println("lower:" + ts.lower("さしすせそ"));

		System.out.println("--- 逆順に表示 ---");
		Iterator it = ts.descendingIterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		NavigableSet ns = ts.descendingSet();
		System.out.println(ns);
		ns = ts.headSet("さしすせそ", true);
		System.out.println("head" + ns);
		ns = ts.tailSet("さしすせそ", true);
		System.out.println("tail" + ns);
		System.out.println(ts.pollFirst());
		System.out.println(ts.pollLast());
		System.out.println("cut" + ts);
	}
}
