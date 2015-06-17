import java.util.Enumeration;
import java.util.Hashtable;

public class Sample36_9 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Hashtable ht = new Hashtable();
		ht.put("あ", "No.1");
		ht.put("か", "No.2");
		ht.put("さ", "No.3");
		ht.put("た", "No.4");
		ht.put("な", "No.5");
		Enumeration keys = ht.keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			System.out.println(key + ":" + ht.get(key));
		}
	}

}
