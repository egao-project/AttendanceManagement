

import java.util.Vector;

public class Sample35_3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Vector vc = new Vector(3);
		System.out.println("Capacity:" + vc.capacity());
		vc.addElement(new Integer(10));
		vc.addElement(new Integer(20));
		vc.addElement(new Double(3.14));
		vc.addElement(123);
		System.out.println(vc);
		System.out.println("Size:" + vc.size());
		System.out.println("Capacity:" + vc.capacity());
		System.out.println("123:" + vc.contains(123));
		System.out.println("First:" + vc.firstElement());
		System.out.println("Last:" + vc.lastElement());
	}

}
