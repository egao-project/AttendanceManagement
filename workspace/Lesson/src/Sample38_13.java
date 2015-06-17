import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

public class Sample38_13 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			al1.add(i);
		}
		System.out.println("al1:" + al1);

		Vector<Integer> vec = new Vector<Integer>(al1);
		System.out.print("vec:" + vec + "\nvec:");
		Enumeration<Integer> en = vec.elements();
		while (en.hasMoreElements()) {
			System.out.print(en.nextElement() + " ");
		}
		System.out.print("\nal1:");

		Enumeration<Integer> en2 = Collections.enumeration(al1);
		while (en2.hasMoreElements()) {
			System.out.print(en2.nextElement() + " ");
		}
		System.out.println();

		Enumeration<Integer> en3 = Collections.enumeration(al1);
		ArrayList<Integer> al2 = Collections.list(en3);
		System.out.println("al2:" + al2);
	}

}
