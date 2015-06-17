public class Sample37_10 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(method(1));		//Integerにオートボクシング
		System.out.println(method("a"));
		System.out.println(method(new Double(3.14)));
	}

	public static <T> T method(T x) {
		System.out.println(x.getClass());
		return x;
	}

}
