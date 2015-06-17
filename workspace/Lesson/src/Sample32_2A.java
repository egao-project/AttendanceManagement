public class Sample32_2A extends Thread {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new Sample32_2A().start();
	}

	@Override
	public void run() {
		for (int no = 0; no < 5; no++) {
			System.out.println(no + "回目");
		}
	}
}