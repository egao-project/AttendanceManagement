package lesson1;

import java.util.Scanner;

public class MyTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scn = new Scanner(System.in);
		System.out.print("星を何個表示しますか？");
		int val = scn.nextInt();
		for (int i = 0; i < val; i++) {
			System.out.print("★");
		}
	}
}