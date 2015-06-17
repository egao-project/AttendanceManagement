import java.util.ArrayList;

public class Sample35_2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList al = new ArrayList();
		al.add("Item-0");
		al.add("Item-2");
		al.add("Item-3");
		System.out.println(al);
		al.ensureCapacity(100);	 // サイズを100に変更
		al.add(1, "Item-1");
		System.out.println(al);
		System.out.println("size:" + al.size());
		al.remove("Item-2");
		System.out.println(al);
		System.out.println("size:" + al.size());
		al.trimToSize();		 // 現在のサイズに変更
	}

}
