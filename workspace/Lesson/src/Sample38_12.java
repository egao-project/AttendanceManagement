import java.util.ArrayList;
import java.util.Collections;

public class Sample38_12 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<Object> list1 = new ArrayList<Object>();
		ArrayList<Object> list2 = new ArrayList<Object>();
		for (int i = 10; i < 13; i++) {
			list1.add(i);
		}
		for (int i = 85; i < 90; i++) {
			list2.add(i);
		}
		System.out.println("list1:" + list1);
		System.out.println("list2:" + list2);

		// list1をlist2へコピー
		Collections.copy(list2, list1);
		System.out.println("list2:" + list2);

		// list1の要素をABに変換
		Collections.fill(list1, "AB");
		System.out.println("list1:" + list1);

		list2.addAll(0, Collections.nCopies(3, "AB"));
		list2.addAll(Collections.nCopies(3, "AB"));
		System.out.println("list2:" + list2);

		int pos1 = Collections.indexOfSubList(list2, list1);
		System.out.println("pos1 = " + pos1);

		int pos2 = Collections.lastIndexOfSubList(list2, list1);
		System.out.println("pos2 = " + pos2);

		Collections.replaceAll(list2, "AB", "あ");
		System.out.println("list2:" + list2);

		// 5番目の要素と、最後の要素を交換
		Collections.swap(list2, 5, list2.size() - 1);
		System.out.println("list2:" + list2);
	}

}
