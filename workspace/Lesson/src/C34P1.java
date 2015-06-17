import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class C34P1 {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		Set hs = new HashSet();

		System.out.print("入力：");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		// 入力と挿入の繰り返し
		while ((str = br.readLine()) != null) {
			System.out.print("入力：");
			hs.add(str);
		}

		// 改行
		System.out.println();

		// for-each文
		System.out.print("(for)");
		for (Object o : hs) {
			System.out.print(o + " ");
		}

		// 改行
		System.out.println();

		// イテレーター
		Iterator it = hs.iterator();
		System.out.print("(ite)");
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}

}