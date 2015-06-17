import java.util.Arrays;

public class Sample38_10 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String[] array = { "Java", "Prolog", "Lisp" };
		String[] array1 = Arrays.copyOf(array, array.length);
		System.out.println(Arrays.equals(array, array1));
		
		String[] array2 = Arrays.copyOfRange(array, 0, 2);
		System.out.println(Arrays.equals(array, array2));

		System.out.println("普通の文字列表現：" + array);
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
	}

}
