import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class C38P2 {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		HashMap hm = new HashMap();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("入力：");
		String msg = br.readLine();
		
		for (int i = 0; i < msg.length(); i++) {
			char ch = msg.charAt(i);
			if (hm.get(ch) == null) {
				hm.put(ch, 1);
			} else {
				hm.put(ch, (Integer) hm.get(ch) + 1);
			}
		}
		
		Iterator it = hm.entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry me = (Map.Entry) it.next();
			System.out.println(me.getKey() + ":" + me.getValue() + " ");
		}
	}
}
