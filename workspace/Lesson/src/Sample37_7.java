import java.util.ArrayList;

public class Sample37_7 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<?> a1 = new ArrayList<String>();
		a1.add("Hello"); 		// NG
		ArrayList<? super Dog1> a2 = new ArrayList<Dog1>();
		a2.add(new Animal1()); 	// NG
		a2.add(new Dog1()); 	// OK
	}
}

class Animal1 {
}

class Dog1 extends Animal1 {
}
