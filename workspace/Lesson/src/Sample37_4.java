public class Sample37_4 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Box1 b1 = new Box1(123);
		Box1 b2 = new Box1("abc");
		System.out.println(b1.get());
		System.out.println(b2.get());
	}

}

class Box1 {
	Object obj;

	public Box1(Object obj) {
		this.obj = obj;
	}

	public Object get() {
		return obj;
	}
}
