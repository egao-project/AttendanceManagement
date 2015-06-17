/**
 * Consoleクラスを利用し表示するプログラム
 * @author tk
 * @version 1.1
 * @since 2015.04.28
 */

package lesson1;

import java.io.Console;

public class C33P1 {
	public static void main(String[] args) {
		Console cns = System.console();
		System.out.print("入力してください：");
		String str = cns.readLine();
		System.out.println("入力されたデータ：" + str);
	}
}