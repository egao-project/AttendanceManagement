import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ListIterator;

public class C35P1 {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList al = new ArrayList();

		System.out.print("入力：");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		// 入力と挿入の繰り返し
		while ((str = br.readLine()) != null) {
			System.out.print("入力：");
			al.add(str);
		}

		// 改行
		System.out.println();

		// 前方表示
		System.out.print("(前方)");
		ListIterator li = al.listIterator();
		while (li.hasNext()) {
			System.out.print(li.next() + " ");
		}
		System.out.println();

		// 後方表示
		System.out.print("(後方)");
		while (li.hasPrevious()) {
			System.out.print(li.previous() + " ");
		}
		System.out.println();
	}
}
