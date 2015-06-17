import java.util.ArrayList;

public class Sample37_2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("abc");
		myList.add("def");
		myList.add("ghi");
		//myList.add(30); //コンパイルエラー
		String s = myList.get(0);
		System.out.println(s + "(" + s.length() + ")");
		for (String msg : myList) {
			System.out.println(msg + "(" + msg.length() + ")");
		}
	}

}
