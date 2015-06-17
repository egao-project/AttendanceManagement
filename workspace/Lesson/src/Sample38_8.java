import java.util.Arrays;

public class Sample38_8 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String[] array = { "Java", "C", "Prolog", "Lisp", "Fortran" };

		// バイナリサーチを使うにはソートデータが必要
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		// Javaは何番目か？
		String key = "Java";
		int pos = Arrays.binarySearch(array, key);
		System.out.println(key + "は" + (pos + 1) + "番目");

		// 無いものを指定 -1で表示される
		// String key = "Aaaa";
		// int pos = Arrays.binarySearch(array, key);
		// System.out.println(key + "は" + (pos) + "番目");
		
		
	}

}
