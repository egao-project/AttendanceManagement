import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class Sample34_4 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Collection col = new TreeSet();
		col.add("Item-1");
		col.add("Item-2");
		col.add("Item-3");
		System.out.println(col);

		// イテレーター
		Iterator it = col.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			it.remove();
			System.out.println(col);
		}
	}

}