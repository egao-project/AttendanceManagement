import java.util.ArrayList;

public class Sample37_6B {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<Dog> dog = new ArrayList<Dog>();
		dog.add(new Dog());
		dog.add(new Dog());
		ArrayList<Cat> cat = new ArrayList<Cat>();
		cat.add(new Cat());
		cat.add(new Cat());
		show(dog);
		show(cat);
	}

	static void show(ArrayList<? extends Animal> animals) {
		for (Object a : animals) {
			((Animal) a).show();
		}
	}
}