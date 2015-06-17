import java.util.LinkedList;

public class Sample35_8 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		LinkedList llist = new LinkedList();
		llist.add("Item-2");
		llist.add("Item-3");
		llist.add("Item-4");
		llist.add("Item-5");
		System.out.println(llist);

		llist.addFirst("Item-0");
		llist.addLast("Item-6");
		System.out.println(llist);

		llist.add(1, "Item-1");
		System.out.println(llist);

		llist.remove("Item-6");
		System.out.println(llist);

		llist.removeLast();
		System.out.println(llist);

		llist.set(2, "item-X");
		System.out.println(llist);
	}

}
