package ball;

/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "BallReflection"
 * BallReflection.java 「ウィンドウの内側を反射するボール」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac *.java
 *     >java BallReflection
 * 【キーワード】
 *     画面のリフレッシュレート(refresh rate:垂直走査周波数)
 * 【試してみよう】
 *     タイマーの発生間隔を変えて、アニメーションの見え方を比べる。
 *     ウィンドウのサイズを変更可能にし、フレーム内で跳ね返るようにする。
 */
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.Timer;

import ball.panel.*;
import ball.shape.*;


public class BallReflection extends JFrame {
	/**
	 * フレーム名称
	 */
	private final static String FRAME_TITLE = "アニメーションフォーム";

	/**
	 * デフォルト更新頻度
	 */
	final static int REFRESH_RATE = 30;

	/**
	 * コンストラクタ
	 */
	public BallReflection() {
		AppData appData = AppData.getInstance();

		// アニメーション表示パネルの作成
		DrawPanelBase panel = new DrawPanelNormal(appData.getWidth(),
				appData.getHeight());
		if ("gravity".compareToIgnoreCase(appData.getType()) == 0) {
			panel = new DrawPanelGravity(appData.getWidth(),
					appData.getHeight());
		} else if ("wind".compareToIgnoreCase(appData.getType()) == 0) {
			panel = new DrawPanelWind(appData.getWidth(), appData.getHeight());
		}

		// フレームにパネルを追加
		this.add(panel);

		int timerTime = REFRESH_RATE;
		if (0 < appData.getWait()) {
			timerTime = appData.getWait();
		}

		new Timer(timerTime, panel).start();
	}

	/**
	 * エントリーポイント
	 * @param args
	 */
	public static void main(String[] args) {
		ParseCommandLine(args);

		// Frameの作成
		JFrame frame = new BallReflection();
		frame.setTitle(FRAME_TITLE);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBackground(Color.white);
		frame.setResizable(false);

		// Frameの表示
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * コマンドライン解析
	 * @param args
	 */
	public static void ParseCommandLine(String[] args) {

		AppData appData = AppData.getInstance();
		boolean isType = false;
		boolean isWait = false;
		boolean isWidth = false;
		boolean isHeight = false;
		boolean isShape = false;
		for (String word : args) {
			System.out.println(word);

			if (isType == true) {
				// Type
				appData.setType(word);
			} else if (isWait == true) {
				// Wait
				try {
					appData.setWait(Integer.parseInt(word));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			} else if (isWidth == true) {
				// Width
				try {
					appData.setWidth(Integer.parseInt(word));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			} else if (isHeight == true) {
				// Height
				try {
					appData.setHeight(Integer.parseInt(word));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			} else if (isShape == true) {
				// Height
				try {
					appData.setShapeCount(Integer.parseInt(word));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}

			isType = false;
			isWait = false;
			isWidth = false;
			isHeight = false;
			if ("-type".equals(word) || "-T".equals(word)) {
				isType = true;
			} else if ("-wait".equals(word) || "-W".equals(word)) {
				isWait = true;
			} else if ("-width".equals(word)) {
				isWidth = true;
			} else if ("-height".equals(word)) {
				isHeight = true;
			} else if ("-shape".equals(word)) {
				isShape = true;
			}
		}
	}
}