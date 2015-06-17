import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Sample36_6 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		TreeMap tm = new TreeMap();
		for (int cnt = 8; cnt >= 0; cnt -= 2) {
			tm.put(String.format("Key%02d", cnt), String.format("Val%02d", cnt));
		}
		System.out.println("要素数：" + tm.size());
		Set es = tm.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry me = (Map.Entry) it.next();
			System.out.format("%s/%s ", me.getKey(), me.getValue());
		}
		System.out.println();
		String key = (String) tm.floorKey("Key05");
		System.out.printf("floorKey(Key05)=%s%n", key);
		Map.Entry me = tm.floorEntry("Key05");
		System.out.printf("%s-%s%n", me.getKey(), me.getValue());
		key = (String) tm.ceilingKey("Key05");
		System.out.printf("ceilingKey(Key05)=%s%n", key);
		me = tm.ceilingEntry("Key05");
		System.out.printf("%s-%s", me.getKey(), me.getValue());
	}

}
