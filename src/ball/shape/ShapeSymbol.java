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

public abstract class ShapeSymbol {

	/**
	 * 現在位置 X
	 */
	private double x;

	/**
	 * 現在位置 Y
	 */
	private double y;

	/**
	 * ボールサイズ
	 */
	private int size;

	/**
	 * 進行方向 X
	 */
	private double vectorX;

	/**
	 * 進行方向 Y
	 */
	private double vectorY;

	/**
	 * イメージカラー
	 */
	private Color color;

	/**
	 * コンストラクタ
	 */
	public ShapeSymbol(int size, int width, int height, Color color) {
		this.size = size;
		this.color = color;

		x = (Math.random() * (width - size));
		y = (Math.random() * (height - size));

		// 進行方向はランダム
		if (Math.random() > 0.5) {
			vectorX = 1;
		} else {
			vectorX = -1;
		}
		if (Math.random() > 0.5) {
			vectorY = 1;
		} else {
			vectorY = -1;
		}
		vectorX *= (Math.random() * width / 10);
		vectorY *= (Math.random() * height / 10);
	}

	/**
	 * 現在地 Xの取得
	 */
	public double getX() {
		return x;
	}

	/**
	 * 現在地 Yの取得
	 */
	public double getY() {
		return y;
	}

	/**
	 * サイズの取得
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 色の取得
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * ボールアクション
	 */
	public void action(double diffX, double diffY) {
		vectorX += diffX;
		vectorY += diffY;

		x += vectorX;
		y += vectorY;
	}

	/**
	 * ボール横　衝突アクション
	 */
	public void conflictActionX(double diffX) {
		x += diffX;
		vectorX *= -0.98;
	}

	/**
	 * ボール横　衝突アクション
	 */
	public void conflictActionY(double diffY) {
		y += diffY;
		vectorY *= -0.9998;
	}

	/**
	 * スピードアップ
	 */
	public void speedUp() {
		vectorX *= 1.1;
		vectorY *= 1.1;

		System.out.println("pre" + vectorX + "," + vectorY);
		if (Math.abs(vectorX) < 5) {
			vectorX = 50 * Math.signum(vectorX) * Math.random();
		}
		if (Math.abs(vectorY) < 5) {
			vectorY = 50 * Math.signum(vectorY) * Math.random();
		}
		System.out.println("  end" + vectorX + "," + vectorY);
	}

	/**
	 * ボールの描画
	 */
	public abstract void draw(Graphics grapchic);
}