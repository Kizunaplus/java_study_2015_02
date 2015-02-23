package ball;

public class AppData {

	/**
	 * シングルトンインスタンス
	 */
	private static AppData instance;

	/**
	 * 環境の種類
	 */
	public String type;

	/**
	 * 更新頻度
	 */
	public int wait;

	/**
	 * ウィンドウ幅
	 */
	public int width;

	/**
	 * ウィンドウ高さ
	 */
	public int height;

	/**
	 * シェープ最大数
	 */
	public int shapeCount;

	/**
	 * クラス生成はさせない
	 */
	private AppData() {
		this.shapeCount = 30;
	}

	/**
	 * シングルトンインスタンスの取得
	 */
	public static AppData getInstance() {
		if (instance == null) {
			synchronized (AppData.class) {
				// ここで再度チェックするため、「二重チェック」と呼ばれる
				if (instance == null) {
					instance = new AppData();
				}
			}
		}
		return instance;
	}

	/**
	 * 環境の種類の取得
	 */
	public String getType() {
		return type;
	}

	/**
	 * 環境の種類の設定
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 更新頻度の取得
	 */
	public int getWait() {
		return wait;
	}

	/**
	 * 更新頻度の設定
	 */
	public void setWait(int wait) {
		this.wait = wait;
	}

	/**
	 * ウィンドウ幅の取得
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * ウィンドウ幅の設定
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * ウィンドウ高さの取得
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * ウィンドウ高さの設定
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * 画像最大表示数の取得
	 */
	public int getShapeCount() {
		return shapeCount;
	}

	/**
	 * 画像最大表示数の設定
	 */
	public void setShapeCount(int shapeCount) {
		this.shapeCount = shapeCount;
	}

}