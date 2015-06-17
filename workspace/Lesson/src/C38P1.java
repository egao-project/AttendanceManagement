import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class C38P1 {

	public static void main(String[] args) throws IOException {

		PriorityQueue pq = new PriorityQueue(11, new C38P1Sort());
		TreeSet ts = new TreeSet(11, new C38P1Sort());

		System.out.print("入力：");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		// 入力と挿入の繰り返し
		while ((str = br.readLine()) != null) {
			System.out.print("入力：");
			pq.add(str);
			ts.add(str);
		}

		// 改行
		System.out.println();

		// PriorityQueue
		System.out.println("--- PriorityQueue ---");
		Object obj;
		while ((obj = pq.poll()) != null) {
			new C38P1Method((String) obj);
			System.out.println(obj);
		}
	}
}

// 降順でソート
class C38P1Sort implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		return (((String) o2).length() - ((String) o1).length());
	}
}

class C38P1Method {
	String str;

	C38P1Method(String str) {
		this.str = str;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof C38P1Method) {
			return (str == ((String) o));
		}
		return (false);
	}
}
