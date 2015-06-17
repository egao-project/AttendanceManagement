import java.util.ArrayList;


public class Sample37_3A {

	void myMethod(ArrayList<String> al) {
		al.add("foo");
		// al.add(30); // コンパイルエラー
	}

	public ArrayList<String> newArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		return list;
	}

}