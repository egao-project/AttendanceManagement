package lesson1;

import java.util.Scanner;

public class P1_2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scn = new Scanner(System.in);
		System.out.print("整数を入力してください：");
		int val = scn.nextInt();
		if (val % 3 == 0) {
			System.out.println("3で割り切れます");
		} else {
			System.out.println("3で割り切れません");
		}
	}
}