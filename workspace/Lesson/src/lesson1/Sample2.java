// デッバカの利用

package lesson1;

import java.util.Scanner;

public class Sample2 {

	public Sample2() {
		int max = read();
		for (int i = 0; i < max; i++) {
			System.out.print("★");
		}
	}

	private int read() {
		Scanner scn = new Scanner(System.in);
		System.out.print("星を何個表示しますか？");
		return (scn.nextInt());
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new Sample2();
	}

}
