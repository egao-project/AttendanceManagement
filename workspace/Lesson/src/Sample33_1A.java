// ドキュメーテーションコメント



/**
 * Javadocテスト用クラス
 *
 * @author JavaTester
 * @version 1.0
 * @see <a href="http://java.sun.com/">sun</a>
 * @since 2015.04.28
 */

public class Sample33_1A {
	/** 幅 */
	private int w;

	/** 高さ */
	public int h;

	/** デフォルトコンストラクタ */
	public Sample33_1A() {
		w = 0;
		h = 0;
	}

	/**
	 * サイズの設定
	 *
	 * @param width
	 *            幅
	 * @param height
	 *            高さ
	 * @exception java.lang.ArithmeticException
	 *                指定されたデータが0の場合に発生
	 */
	public void setSize(int width, int height) {
		w = width;
		h = height;
	}

	/**
	 * 幅の取得
	 *
	 * @return 幅
	 * @see Sample33_1A#setSize(int w, int h)
	 */
	public int getWidth() {
		return w;
	}

	/**
	 * 高さの取得
	 *
	 * @return 幅
	 * @see Sample33_1A#setSize(int w, int h)
	 */
	public int getHeight() {
		return h;
	}
}