import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Sample36_1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Map hm = new HashMap();
		hm.put("Key0", "Val0");
		hm.put("Key1", "Val1");
		hm.put("Key2", "ValX");
		hm.put("Key3", "Val3");
		hm.put("Key4", "ValX");
		hm.put("Key4", "ValY");
		System.out.println("要素数：" + hm.size());
		System.out.println(hm);

		Collection values = hm.values();
		System.out.println(values);
		Set keys = hm.keySet();
		System.out.println(keys);
		System.out.println("Key3:" + hm.containsKey("Key3"));
		System.out.println("Val3:" + hm.containsValue("Val3"));
		String val = (String) hm.get("Key3");
		System.out.println("get(Key3):" + val);

		// セットとしての操作
		Set es = hm.entrySet();
		System.out.println(es);
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.print(obj + " ");
			Map.Entry me = (Map.Entry) obj;
			System.out.print(me.getKey() + "/" + me.getValue() + " ");
		}
		System.out.println();

		hm.remove("Key3");
		System.out.println(hm);
		System.out.println("Empty:" + hm.isEmpty());
		hm.clear();
		System.out.println(hm);
		System.out.println("Empty:" + hm.isEmpty());

	}

}
