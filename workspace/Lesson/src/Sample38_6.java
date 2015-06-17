
import java.util.Arrays;

public class Sample38_6 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int[] array = { 3, 50, 1, 6, 120, 45, 60 };

		System.out.println("ソート前");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		System.out.println("\nソート後");
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
