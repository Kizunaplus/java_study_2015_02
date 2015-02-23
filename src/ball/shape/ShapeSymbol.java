package ball.shape;

/**
 * ����Java256�{�m�b�N for Java 5.0
 * Java�T���v���\�[�X ver0.2C "BallReflection"
 * Ball.java �u�E�B���h�E�̓����𔽎˂���{�[���v
 *
 * 2005/09/23 ����F���i�m���J�Y
 *
 * �y�R���p�C�������s���@�z
 *     >javac *.java
 *     >java BallReflection
 * �y�L�[���[�h�z
 *     ����(random), �ȉ~(oval)�̕`��, �`��F�̎w��, ���ˊp�Ɣ��ˊp
 *     
 * �y�����Ă݂悤�z
 *     �F���w��ł���悤�ɂ���B
 *     �ړ��X�s�[�h���w��ł���悤�ɂ���B
 */
import java.awt.Color;
import java.awt.Graphics;

public abstract class ShapeSymbol {

	/**
	 * ���݈ʒu X
	 */
	private double x;

	/**
	 * ���݈ʒu Y
	 */
	private double y;

	/**
	 * �{�[���T�C�Y
	 */
	private int size;

	/**
	 * �i�s���� X
	 */
	private double vectorX;

	/**
	 * �i�s���� Y
	 */
	private double vectorY;

	/**
	 * �C���[�W�J���[
	 */
	private Color color;

	/**
	 * �R���X�g���N�^
	 */
	public ShapeSymbol(int size, int width, int height, Color color) {
		this.size = size;
		this.color = color;

		x = (Math.random() * (width - size));
		y = (Math.random() * (height - size));

		// �i�s�����̓����_��
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
	 * ���ݒn X�̎擾
	 */
	public double getX() {
		return x;
	}

	/**
	 * ���ݒn Y�̎擾
	 */
	public double getY() {
		return y;
	}

	/**
	 * �T�C�Y�̎擾
	 */
	public int getSize() {
		return size;
	}

	/**
	 * �F�̎擾
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * �{�[���A�N�V����
	 */
	public void action(double diffX, double diffY) {
		vectorX += diffX;
		vectorY += diffY;

		x += vectorX;
		y += vectorY;
	}

	/**
	 * �{�[�����@�Փ˃A�N�V����
	 */
	public void conflictActionX(double diffX) {
		x += diffX;
		vectorX *= -0.98;
	}

	/**
	 * �{�[�����@�Փ˃A�N�V����
	 */
	public void conflictActionY(double diffY) {
		y += diffY;
		vectorY *= -0.9998;
	}

	/**
	 * �X�s�[�h�A�b�v
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
	 * �{�[���̕`��
	 */
	public abstract void draw(Graphics grapchic);
}