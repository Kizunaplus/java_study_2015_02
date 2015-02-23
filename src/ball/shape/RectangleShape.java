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

public class RectangleShape extends ShapeSymbol {
	/**
	 * �R���X�g���N�^
	 */
	public RectangleShape(int size, int width, int height, Color color) {
		super(size, width, height, color);
	}

	/**
	 * �{�[���̕`��
	 */
	public void draw(Graphics grapchic) {
		grapchic.setColor(this.getColor());
		grapchic.fillRect((int) this.getX(), (int) this.getY(), this.getSize(),
				this.getSize());
	}
}