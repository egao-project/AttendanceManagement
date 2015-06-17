public class Sample37_8 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		UseTwo<String, Integer> a = new UseTwo<String, Integer>("a", 1);
		System.out.println(a.getT());
		System.out.println(a.getX());
	}

}

class UseTwo<T, X> {
	T one;
	X two;

	UseTwo(T one, X two) {
		this.one = one;
		this.two = two;
	}

	T getT() {
		return one;
	}

	X getX() {
		return two;
	}
}
