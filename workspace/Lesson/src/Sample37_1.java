import java.util.ArrayList;

public class Sample37_1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList myList = new ArrayList();
		myList.add("abc");
		myList.add("def");
		myList.add("ghi");
		String s = (String) myList.get(0);
		System.out.println(s + "(" + s.length() + ")");
		for (Object obj : myList) {
			String msg = (String) obj;
			System.out.println(msg + "(" + msg.length() + ")");
		}
	}

}
