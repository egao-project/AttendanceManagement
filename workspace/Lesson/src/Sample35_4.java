import java.util.Stack;

public class Sample35_4 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Stack st = new Stack();
		System.out.println("empty:" + st.empty());
		st.push(new Integer(10));
		st.push(new Integer(20));
		st.push(30);
		System.out.println(st);
		System.out.println("peek:" + st.peek());
		System.out.println(st);
		System.out.println("pop:" + st.pop());
		System.out.println(st);
		System.out.println("serch(10):" + st.search(10));
		System.out.println("serch(20):" + st.search(20));
		System.out.println("serch(50):" + st.search(50));
		System.out.println("pop:" + st.pop());
		System.out.println("pop:" + st.pop());
		System.out.println("empty:" + st.empty());
		System.out.println(st.pop());
	}

}
