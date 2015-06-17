import java.util.Collection;

public class C35P2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		for (int i = 1000; i < 100000; i *= 10) {
			System.out.prinf(addMethod(ArrayList, i));
			addMethod(Vector, i);
			addMethod(Stack, i);
			addMethod(PriorityQueue, i);
			addMethod(LinkedList, i);
		}
	}

	static void addMethod(Collection obj, int num) {
		long tm1 = System.nanoTime();
		for(int i = 0; i < num; i++){
			obj.add(i);
		}
		long tm2 = System.nanoTime();
		System.out.printf("%s:%12d",toString(),tm2-tm1);
	}
}