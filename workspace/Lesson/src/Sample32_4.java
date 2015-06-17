@SuppressWarnings("deprecation")
public class Sample32_4 extends Thread {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Thread th = new Sample32_4();
		th.start();
		th.stop();
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("abc");
		}
	}

}