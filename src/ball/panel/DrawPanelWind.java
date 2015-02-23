package ball.panel;

/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "BallReflection"
 * DrawPanel.java 「ウィンドウの内側を反射するボール」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac *.java
 *     >java BallReflection
 * 【キーワード】
 *     イベント駆動(event-driven)プログラム, コンポーネントの再描画(repaint), 
 *     コールバック(callback)メソッド,
 *     イベントディスパッチスレッド(event dispatch thread), 
 * 【試してみよう】
 *     ボールの数を増やして配列で管理する。
 */
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import ball.shape.*;

public class DrawPanelWind extends DrawPanelBase {
	
	/**
	 * 風の吹く時間
	*/
	private final int WIND_COUNT = 500;
	
	/**
	 * 風が吹いている時間
	*/
	private int windTime = 0;

	/**
	 * コンストラクタ
	 */
	public DrawPanelWind(int width, int height) {
		super(width, height);
	}

	/**
	 * アクションイベント
	 */
	public void actionPerformed(ActionEvent action) {
		Dimension size = getPreferredSize();
		double wind = 5 * Math.random();
		windTime++;
		if (windTime / WIND_COUNT % 2 == 1) {
			// 偶数の場合は、風が止む
			wind = 0;
		}
		
		
		if (windTime / WIND_COUNT % 4 == 0) {
			// 4の倍数場合は、逆の風が吹く
			wind *= -1;
		}

		for (ShapeSymbol ball : this.getShapes()) {
			ball.action(wind, 0);

			// 壁に衝突すれば反射
			if (ball.getX() >= (size.getWidth() - ball.getSize())) {
				ball.conflictActionX((int) (size.getWidth() - ball.getSize())
						- ball.getX());
			} else if (ball.getX() <= 0) {
				ball.conflictActionX(ball.getX() * -1);
			}

			if (ball.getY() >= (size.getHeight() - ball.getSize())) {
				ball.conflictActionY((int) (size.getHeight() - ball.getSize())
						- ball.getY());
			} else if (ball.getY() <= 0) {
				ball.conflictActionY(ball.getY() * -1);
			}
		}

		repaint();
	}
}
