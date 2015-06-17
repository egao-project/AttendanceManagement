import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class C38P6 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<Integer> al = new ArrayList<Integer>();
		Random rnd = new Random();
		for (int cnt = 0; cnt < 50; cnt++) {
			al.add(rnd.nextInt(90) + 10);
		}

		Integer[] array = al.toArray(new Integer[0]);

		Arrays.sort(array);

		System.out.println(Arrays.toString(array));
	}
}