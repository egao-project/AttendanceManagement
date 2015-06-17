import java.util.SortedMap;
import java.util.TreeMap;

public class Sample36_5 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		SortedMap tm = new TreeMap();
		for (int cnt = 4; cnt >= 0; cnt--) {
			tm.put("Key" + cnt, "Val" + cnt);
		}
		System.out.println("要素数：" + tm.size());
		System.out.println(tm);
		String fk = (String) tm.firstKey();
		System.out.println("first:" + fk);
		String lk = (String) tm.lastKey();
		System.out.println("last:" + lk);
		SortedMap sm = tm.subMap("Key1", "Key3");
		System.out.println(sm);
		sm = tm.headMap("Key3");
		System.out.println(sm);
		sm = tm.tailMap("Key3");
		System.out.println(sm);
	}

}
