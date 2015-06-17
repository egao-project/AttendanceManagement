import java.util.Arrays;

public class Sample38_9 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String[] array = new String[10];
		
		//arrayの3番目から7未満を指定してJavaで埋める
		Arrays.fill(array, 3, 7, "Java");		
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		String[] array1 = { "Java", "Prolog", "Lisp" };
		String[] array2 = { "Java", "Prolog", "Lisp" };
		System.out.println(Arrays.equals(array, array1));
		System.out.println(Arrays.equals(array1, array2));
	}

}
