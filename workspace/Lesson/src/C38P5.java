import java.util.ArrayList;
import java.util.Random;

public class C38P5 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<Integer> al = new ArrayList<Integer>();
		Random rnd = new Random();
		for (int cnt = 0; cnt < 50; cnt++) {
			al.add(rnd.nextInt(90) + 10);
		}

		Integer[] array = al.toArray(new Integer[0]);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
