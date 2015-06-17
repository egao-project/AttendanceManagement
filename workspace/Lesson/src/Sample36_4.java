import java.util.WeakHashMap;

public class Sample36_4 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		WeakHashMap whm = new WeakHashMap();
		String strong[] = new String[5];
		for (int cnt = 0; cnt < strong.length; cnt++) {
			strong[cnt] = "Key" + cnt;
			whm.put(strong[cnt], "Val" + cnt);
		}
		System.out.println(whm);
		strong[1] = null; // 強参照を無くす
		System.gc();
		System.out.println(whm);
	}

}
