import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Sample34_2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		test(new TreeSet());
		test(new HashSet());
		test(new LinkedList());
		test(new ArrayList());

	}

	static void test(Collection col) {
		System.out.printf("--- %s ---%n", col.getClass());
		for (int i = 1; i <= 10000; i++) {
			col.add("item-" + 1);
		}

		long tm1 = System.nanoTime();
		col.add("Item-5001A");
		long tm2 = System.nanoTime();
		for (Object o : col) {
		}
		long tm3 = System.nanoTime();
		col.contains("Item-1");
		long tm4 = System.nanoTime();
		col.add("Item-5000");
		long tm5 = System.nanoTime();
		col.add("Item-10000");
		long tm6 = System.nanoTime();
		col.remove("Item-5000");
		long tm7 = System.nanoTime();
		
		System.out.printf("追加(中央):%,12d%n", tm2 - tm1);
		System.out.printf("参照(全体):%,12d%n", tm3 - tm2);
		System.out.printf("検索(前方):%,12d%n", tm4 - tm3);
		System.out.printf("検索(中央):%,12d%n", tm5 - tm4);
		System.out.printf("検索(後方):%,12d%n", tm6 - tm5);
		System.out.printf("削除(中央):%,12d%n", tm7 - tm6);
	}

}
