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

public class DrawPanelNormal extends DrawPanelBase {

	/**
	 * コンストラクタ
	 */
	public DrawPanelNormal(int width, int height) {
		super(width, height);
	}

	/**
	 * アクションイベント
	 */
	public void actionPerformed(ActionEvent action) {
		Dimension size = getPreferredSize();

		for (ShapeSymbol ball : this.getShapes()) {
			ball.action(0, 0);

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
