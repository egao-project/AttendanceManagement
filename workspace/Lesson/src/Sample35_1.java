import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Sample35_1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		List col = new ArrayList();
		col.add("Item-1");
		col.add("Item-2");
		col.add("Item-3");
		col.add("Item-3");
		col.add("Item-4");		
		System.out.println(col);
		
		col.add(1, "Item-5");
		System.out.println(col);
		
		System.out.println("get(2):" + col.get(2));
		System.out.println("Item-5:" + col.indexOf("Item-5"));
		System.out.println("LI Item-3:" + col.lastIndexOf("Item-3"));
		
		ListIterator li = col.listIterator();
		
		while (li.hasNext()) {
			System.out.print(li.next() + " ");
		}
		System.out.println();
		ListIterator li2 = col.listIterator(3);
		
		while (li2.hasNext()) {
			System.out.print(li2.next() + " ");
		}
		System.out.println();
		
		col.set(4, "Item-X");
		System.out.println(col);
		List sub = col.subList(2, 4);
		System.out.println(sub);
	}

}
