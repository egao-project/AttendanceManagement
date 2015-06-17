

import java.util.Collection;
import java.util.TreeSet;

public class Sample34_1 {

	public static void main(String[] args) {
		// 以下のコレクションは実装クラスを全く同様に扱うことができる
		// 異なるデータ構造、アルゴリズムを自分で実装することなく簡単に使う事ができる

		Collection col = new TreeSet();
		// Collection col = new HashSet();
		// Collection col = new LinkedHashSet();
		// Collection col = new PriorityQueue();
		// Collection col = new LinkedList();
		// Collection col = new ArrayList();
		// Collection col = new Vector();
		// Collection col = new Stack();

		col.add("Item-1");
		col.add("Item-2");
		col.add("Item-3");

		System.out.println(col);	 // 一覧表示

		for (Object o : col) { 		// 各要素を一つ一つ表示
			System.out.println(o);
		}
	}

}
