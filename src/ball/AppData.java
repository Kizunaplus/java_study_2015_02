package ball;

public class AppData {

	/**
	 * �V���O���g���C���X�^���X
	 */
	private static AppData instance;

	/**
	 * ���̎��
	 */
	public String type;

	/**
	 * �X�V�p�x
	 */
	public int wait;

	/**
	 * �E�B���h�E��
	 */
	public int width;

	/**
	 * �E�B���h�E����
	 */
	public int height;

	/**
	 * �V�F�[�v�ő吔
	 */
	public int shapeCount;

	/**
	 * �N���X�����͂����Ȃ�
	 */
	private AppData() {
		this.shapeCount = 30;
	}

	/**
	 * �V���O���g���C���X�^���X�̎擾
	 */
	public static AppData getInstance() {
		if (instance == null) {
			synchronized (AppData.class) {
				// �����ōēx�`�F�b�N���邽�߁A�u��d�`�F�b�N�v�ƌĂ΂��
				if (instance == null) {
					instance = new AppData();
				}
			}
		}
		return instance;
	}

	/**
	 * ���̎�ނ̎擾
	 */
	public String getType() {
		return type;
	}

	/**
	 * ���̎�ނ̐ݒ�
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * �X�V�p�x�̎擾
	 */
	public int getWait() {
		return wait;
	}

	/**
	 * �X�V�p�x�̐ݒ�
	 */
	public void setWait(int wait) {
		this.wait = wait;
	}

	/**
	 * �E�B���h�E���̎擾
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * �E�B���h�E���̐ݒ�
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * �E�B���h�E�����̎擾
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * �E�B���h�E�����̐ݒ�
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * �摜�ő�\�����̎擾
	 */
	public int getShapeCount() {
		return shapeCount;
	}

	/**
	 * �摜�ő�\�����̐ݒ�
	 */
	public void setShapeCount(int shapeCount) {
		this.shapeCount = shapeCount;
	}

}