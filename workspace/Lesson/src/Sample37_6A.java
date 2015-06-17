import java.util.ArrayList;

public class Sample37_6A {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<Dog> dog = new ArrayList<Dog>();
		dog.add(new Dog());
		dog.add(new Dog());
		ArrayList<Cat> cat = new ArrayList<Cat>();
		cat.add(new Cat());
		cat.add(new Cat());
		show(dog); // コンパイルエラー
		show(cat); // コンパイルエラー
	}

	static void show(ArrayList<Animal> animals) {
		for (Animal a : animals) {
			a.show();
		}
	}
}