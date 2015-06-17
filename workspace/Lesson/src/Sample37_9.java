import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Sample37_9 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Map<String, Integer> map = new TreeMap<String, Integer>();
		map.put("red", 1);
		map.put("blue", 2);
		map.put("green", 3);
		Set<Map.Entry<String, Integer>> es = map.entrySet();
		Iterator<Map.Entry<String, Integer>> it = es.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> e = it.next();
			System.out.println(e.getKey() + ":" + e.getValue());
		}
	}
}
