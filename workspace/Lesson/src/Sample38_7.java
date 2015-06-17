import java.util.Arrays;
import java.util.Comparator;

public class Sample38_7 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String[] data = { "red", "black", "blue", "green" };
//		String[] data = { "abcd", "acde", "abdc", "aced" };


		// 文字列をComparatorを指定してソート
		Arrays.sort(data, new MyComparator());
		for (String obj : data) {
			System.out.println(obj);
		}
	}
}

class MyComparator implements Comparator<String> {
	public int compare(String o1, String o2) {
		return (o2.compareTo(o1));		//降順
//		return (o1.compareTo(o2));		//昇順
	}
}
