

import java.util.ArrayList;
import java.util.Iterator;

public class Sample38_5 {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		list.add("foo");
		list.add("bar");
		list.add("baz");

		// コレクションからStringの配列に変換
		String[] array = list.toArray(new String[0]);
		list.set(1, "BAR"); 						// コレクションの内容を変更
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]); 			// コレクションの変更は配列に影響しない
		}

		System.out.println("----");
		
		array[0] = "FOO"; 							// 配列の内容を変更
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
