import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class Sample38_14 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		TreeSet<Integer> ts1 = new TreeSet<Integer>();
		TreeSet<Integer> ts2 = new TreeSet<Integer>();
		TreeSet<Integer> ts3 = new TreeSet<Integer>();
		for (int i = 10; i < 20; i++) {
			ts1.add(i);
			ts2.add(i + 5);
			ts3.add(i + 10);
		}
		System.out.println("ts1:" + ts1 + "\nts2:" + ts2 + "\nts3:" + ts3);

		boolean bl1 = Collections.disjoint(ts1, ts2);
		boolean bl2 = Collections.disjoint(ts1, ts3);
		System.out.println("disjoint(ts1, ts2) = " + bl1
				+ "\ndisjoint(ts1, ts3) = " + bl2);

		// 自然順序順の逆順のコンパレータを取得
		Comparator<Integer> comp = Collections.reverseOrder();
		TreeSet<Integer> ts4 = new TreeSet<Integer>(comp);
		ts4.addAll(ts1);
		System.out.println("ts4:" + ts4);

		ArrayList<Integer> al = new ArrayList<Integer>(ts1);
		al.addAll(ts2);
		al.addAll(ts3);
		System.out.println("al:" + al);
		System.out.println("10の頻度：" + Collections.frequency(al, 10));
		System.out.println("20の頻度：" + Collections.frequency(al, 20));
	}

}
