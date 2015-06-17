import java.util.LinkedList;
import java.util.Queue;

public class Sample35_5 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Queue queue = new LinkedList();
		System.out.println("size:" + queue.size());
		queue.add(20);
		queue.add(30);
		queue.offer(10);
		System.out.println("size:" + queue.size());
		System.out.println(queue);
		System.out.println("element:" + queue.element());
		System.out.println(queue);
		System.out.println("peek:" + queue.peek());
		System.out.println(queue);
		System.out.println("poll:" + queue.poll());
		System.out.println(queue);
		System.out.println("remove:" + queue.remove());
		System.out.println(queue);
	}

}
