public class Sample37_4A {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Box2<Integer> b1 = new Box2<Integer>(123);
		Box2<String>  b2 = new Box2<String>("abc");

		System.out.println(b1.get());
		System.out.println(b2.get());
	}
}

class Box2<T> {
	T obj;

	public Box2(T obj) {
		this.obj = obj;
	}

	public T get() {
		return obj;
	}
}
