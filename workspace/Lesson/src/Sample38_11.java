import java.util.ArrayList;
import java.util.Collections;

public class Sample38_11 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(3);
		al.add(50);
		al.add(1);
		al.add(6);
		al.add(120);
		al.add(45);
		al.add(60);
		System.out.println("ソート前" + al);

		Collections.sort(al);
		System.out.println("ソート後" + al);

		int index = Collections.binarySearch(al, 45);
		System.out.println("45の位置：" + (index + 1) + "番目");

		Collections.reverse(al);
		System.out.println("逆順：" + al);

		Collections.rotate(al, 2);
		System.out.println("回転" + al);

		Collections.shuffle(al);
		System.out.println("シャッフル" + al);

		System.out.println("最大：" + Collections.max(al));
		System.out.println("最小：" + Collections.min(al));
	}

}
