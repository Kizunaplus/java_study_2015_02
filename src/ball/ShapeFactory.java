package ball;

/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "BallReflection"
 * Ball.java 「ウィンドウの内側を反射するボール」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac *.java
 *     >java BallReflection
 * 【キーワード】
 *     乱数(random), 楕円(oval)の描画, 描画色の指定, 入射角と反射角
 *
 * 【試してみよう】
 *     色を指定できるようにする。
 *     移動スピードも指定できるようにする。
 */
import java.awt.Color;
import ball.shape.*;

public class ShapeFactory {

	/**
	 * 円シンボルの作成
	 *
	 * @param size サイズ
	 * @param width 表示領域幅
	 * @param height 表示領域高さ
	 * @param color シンボルカラー
	 * @return
	 */
	public static ShapeSymbol createCircle(int size, int width, int height,
			Color color) {
		return new CircleShape(size, width, height, color);
	}

	/**
	 * 六角形シンボルの作成
	 *
	 * @param size サイズ
	 * @param width 表示領域幅
	 * @param height 表示領域高さ
	 * @param color シンボルカラー
	 * @return
	 */
	public static ShapeSymbol createPentagon(int size, int width, int height,
			Color color) {
		return new PentagonShape(size, width, height, color);
	}


	/**
	 * 四角シンボルの作成
	 *
	 * @param size サイズ
	 * @param width 表示領域幅
	 * @param height 表示領域高さ
	 * @param color シンボルカラー
	 * @return
	 */
	public static ShapeSymbol createRectangle(int size, int width, int height,
			Color color) {
		return new RectangleShape(size, width, height, color);
	}

	/**
	 * 星シンボルの作成
	 *
	 * @param size サイズ
	 * @param width 表示領域幅
	 * @param height 表示領域高さ
	 * @param color シンボルカラー
	 * @return
	 */
	public static ShapeSymbol createStar(int size, int width, int height,
			Color color) {
		return new StarShape(size, width, height, color);
	}

	/**
	 * ランダムでシンボルを作成
	 *
	 * @param size サイズ
	 * @param width 表示領域幅
	 * @param height 表示領域高さ
	 * @param color シンボルカラー
	 * @return
	 */
	public static ShapeSymbol createRandom(int size, int width, int height,
			Color color) {
		ShapeSymbol shape = null;

		int random = (int) (Math.random() * 3.0);

		if (random == 0) {
			shape = createPentagon(size, width, height, color);
		} else if (random == 1) {
			shape = createRectangle(size, width, height, color);
		} else if (random == 2) {
			shape = createStar(size, width, height, color);
		} else {
			shape = createCircle(size, width, height, color);
		}

		return shape;
	}
}