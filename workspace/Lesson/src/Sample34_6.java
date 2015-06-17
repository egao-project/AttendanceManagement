import java.util.ArrayList;
import java.util.Collection;

public class Sample34_6 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Collection col = new ArrayList();
		System.out.println(col);
		col.add("Item-1");
		col.add("Item-2");
		col.add("Item-3");
		System.out.println(col);

		Collection col2 = new ArrayList();
		col2.add("Item-4");
		col2.add("Item-5");
		col.addAll(col2);
		System.out.println(col);

		System.out.println("Item-3 :" + col.contains("Item-3"));
		System.out.println("Item-6 :" + col.contains("Item-6"));
		System.out.println("contAll:" + col.containsAll(col2));
		col.remove("Item-3");
		System.out.println("Item-3 :" + col.contains("Item-3"));
		col.removeAll(col2);
		System.out.println("contAll:" + col.containsAll(col2));
		System.out.println("Empty  :" + col.isEmpty());
		System.out.println("size   :" + col.size());
		String array[] = (String[]) col.toArray(new String[0]);
		for (String obj : array) {
			System.out.println(obj);
		}
		col.clear();
		System.out.println("size   :" + col.size());
		System.out.println("Empty  :" + col.isEmpty());
	}

}
