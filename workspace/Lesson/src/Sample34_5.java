import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Sample34_5 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		List col = new ArrayList();
		col.add("Item-1");
		col.add("Item-2");
		col.add("Item-3");
		System.out.println(col);

		// リストイテレーター
		ListIterator it = col.listIterator();
		System.out.println("--- 順方向に表示 ---");
		while (it.hasNext()) {
			System.out.print(it.nextIndex() + ":");
			System.out.print(it.next() + " ");
		}

		it.set("Item-X");

		System.out.println("\n" + col);

		System.out.println("--- 逆順方向に表示 ---");
		while (it.hasPrevious()) {
			System.out.print(it.previousIndex() + ":");
			System.out.print(it.previous() + " ");
		}

		System.out.println();

		it.set("item-Y");

		System.out.println(col);
	}

}