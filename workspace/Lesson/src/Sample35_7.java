import java.util.ArrayDeque;

public class Sample35_7 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayDeque ad = new ArrayDeque();
		ad.add("Item-1");
		ad.add("Item-2");
		ad.add("Item-3");
		ad.add("Item-4");
		ad.add("Item-5");
		System.out.println(ad);
		System.out.println(ad.peekFirst());
		System.out.println(ad.peekLast());
		System.out.println(ad);
		System.out.println(ad.pollFirst());
		System.out.println(ad.pollLast());
		System.out.println(ad);
		ad.offerFirst("Item-A");
		ad.offerLast("Item-B");
		System.out.println(ad);
	}

}
