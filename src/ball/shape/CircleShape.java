package ball.shape;

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
import java.awt.Graphics;

public class CircleShape extends ShapeSymbol {
	/**
	 * コンストラクタ
	 */
	public CircleShape(int size, int width, int height, Color color) {
		super(size, width, height, color);
	}

	/**
	 * ボールの描画
	 */
	public void draw(Graphics grapchic) {
		grapchic.setColor(this.getColor());
		grapchic.fillOval((int) this.getX(), (int) this.getY(), this.getSize(),
				this.getSize());
	}
}