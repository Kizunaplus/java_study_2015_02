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
import static java.awt.RenderingHints.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import ball.shape.*;
import ball.*;

public abstract class DrawPanelBase extends JPanel implements ActionListener {
	/**
	 * パネル幅
	 */
	private int width = 600;

	/**
	 * パネル高さ
	 */
	private int height = 400;

	/**
	 * 表示対象のボール
	 */
	private List<ShapeSymbol> shapes;

	/**
	 * コンストラクタ
	 */
	public DrawPanelBase(int width, int height) {
		// 背景色: 白
		setBackground(Color.white);

		if (0 < width) {
			this.width = width;
		}
		if (0 < height) {
			this.height = height;
		}

		// サイズ
		setPreferredSize(new Dimension(this.width, this.height));

		shapes = new ArrayList<ShapeSymbol>();
		ShapeSymbol ball = ShapeFactory.createCircle(
				(int) (45.0 * Math.random() + 5), this.width, this.height,
				Color.orange);
		shapes.add(ball);
		assineMouseEvent();
	}

	/**
	 * 表示シェープリストの取得
	 */
	protected List<ShapeSymbol> getShapes() {
		return this.shapes;
	}

	/**
	 * アクションイベント
	 */
	public abstract void actionPerformed(ActionEvent action);

	/**
	 * マウスクリックイベント
	 */
	public void assineMouseEvent() {

		final List<ShapeSymbol> localShapes = this.shapes;

		// イベントの登録
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				AppData appData = AppData.getInstance();
				while (appData.getShapeCount() < DrawPanelBase.this.shapes.size()) {
					DrawPanelBase.this.shapes.remove(0);
				}

				Dimension size = DrawPanelBase.this.getPreferredSize();
				Color color = new Color((int) (256.0 * Math.random()),
						(int) (256.0 * Math.random()), (int) (256.0 * Math
								.random()));
				ShapeSymbol ball = ShapeFactory.createRandom(
						(int) (45.0 * Math.random() + 5), (int) size.getWidth(),
						(int) size.getHeight(), color);
				DrawPanelBase.this.shapes.add(ball);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				for (ShapeSymbol ball : localShapes) {
					ball.speedUp();
				}
				System.out.println("speed up");
			}
		});
	}

	/**
	 * 描画処理
	 */
	public void paintComponent(Graphics graphic) {
		super.paintComponent(graphic);

		Graphics2D graphic2d = (Graphics2D) graphic;
		graphic2d.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
		for (ShapeSymbol ball : this.shapes) {
			ball.draw(graphic2d);
		}
	}
}
