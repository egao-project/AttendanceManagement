import java.util.Iterator;
import java.util.PriorityQueue;

public class Sample35_6 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		PriorityQueue pq = new PriorityQueue();
		System.out.println("size:" + pq.size());
		pq.add("3");
		pq.add("2");
		pq.add("1");
		pq.add("5");
		pq.add("4");
		pq.add("1");
		System.out.println(pq);
		System.out.println("size:" + pq.size());
		System.out.println("element:" + pq.element());
		System.out.println("peel:" + pq.peek());
		
		System.out.println("--- iteratorで取り出し ---");
		Iterator it = pq.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		
		System.out.println("\n--- poll()で取り出し ---");
		Object obj;
		while ((obj = pq.poll()) != null) {
			System.out.print(obj + " ");
		}
	}

}
