//配列をリストに変換

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Sample38_4 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String[] array = { "foo", "bar", "baz" };

		// 配列をコレクションのListに変換
		List<String> list = Arrays.asList(array);
		array[1] = "BAR"; 							// 配列中の1要素を変更
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next()); 			// 変更がList側にも反映
		}
		System.out.println("----");
		list.set(0, "FOO");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]); 			// 変更が配列側にも反映
		}
		try {
			list.add("zoo");						// 配列の要素数は固定なので例外発生
		} catch (UnsupportedOperationException uoe) {
			System.err.println("配列から変換したListの要素数変更は不可");
		}
	}

}
