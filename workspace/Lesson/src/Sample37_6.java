import java.util.ArrayList;

public class Sample37_6 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList dog = new ArrayList();
		dog.add(new Dog());
		dog.add(new Dog());
		ArrayList cat = new ArrayList();
		cat.add(new Cat());
		cat.add(new Cat());
		show(dog);
		show(cat);
	}

	static void show(ArrayList animals) {
		for (Object a : animals) {
			((Animal) a).show();
		}
	}
}

abstract class Animal {
	public abstract void show();
}

class Dog extends Animal {
	public void show() {
		System.out.println("Dog");
	}
}

class Cat extends Animal {
	public void show() {
		System.out.println("Cat");
	}
}
