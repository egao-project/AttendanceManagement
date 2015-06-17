
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Sample36_2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		HashMap hm = new HashMap(100);
		for (int cnt = 0; cnt < 10; cnt++) {
			hm.put(String.format("Key%02d", cnt), String.format("Val%02d", cnt));
		}
		System.out.println("要素数：" + hm.size());
		HashMap hm2 = new HashMap();
		for (int cnt = 10; cnt < 20; cnt++) {
			hm2.put(String.format("Key%02d", cnt),
					String.format("Val%02d", cnt));
		}
		hm.putAll(hm2);
		System.out.println("要素数：" + hm.size());

		// イテレーターを使って5個ずつ改行して全要素を表示
		Set es = hm.entrySet();
		Iterator it = es.iterator();
		for (int cnt = 0; it.hasNext(); cnt++) {
			Map.Entry me = (Map.Entry) it.next();
			System.out.format("%s/%s ", me.getKey(), me.getValue());
			if (cnt % 5 == 4) {
				System.out.println();
			}
		}
	}
}
