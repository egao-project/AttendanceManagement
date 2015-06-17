import java.util.Collection;
import java.util.TreeSet;

public class Sample34_3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Collection col = new TreeSet();
		col.add("Item-1");
		col.add("Item-2");
		col.add("Item-3");
		System.out.println(col);
		for (Object o : col) {
			System.out.println(o);
		}
	}

}
