import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class C36P1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		for (int i = 1000; i <= 100000; i *= 10) {
			System.out.printf("--- %,d ---%n", i);
			test(new HashMap(), i);
			test(new LinkedHashMap(), i);
			test(new TreeMap(), i);
		}
	}

	static void test(Map map, int val) {
		System.out.printf("%23s ", map.getClass().getName());
		long tm1 = System.nanoTime();
		for (int i = 0; i < val; i++) {
			map.put(new Integer(i), i);
		}
		long tm2 = System.nanoTime();
		System.out.printf("%nInteger:%,12d%n", tm2 - tm1);

		long tm3 = System.nanoTime();
		for (int i = 0; i < val; i++) {
			map.put(new Double(i), i);
		}
		long tm4 = System.nanoTime();
		System.out.printf("Double :%,12d%n", tm4 - tm3);
	}

}
