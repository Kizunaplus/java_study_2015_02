package ball;

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
import ball.shape.*;

public class ShapeFactory {

	/**
	 * �~�V���{���̍쐬
	 *
	 * @param size �T�C�Y
	 * @param width �\���̈敝
	 * @param height �\���̈捂��
	 * @param color �V���{���J���[
	 * @return
	 */
	public static ShapeSymbol createCircle(int size, int width, int height,
			Color color) {
		return new CircleShape(size, width, height, color);
	}

	/**
	 * �Z�p�`�V���{���̍쐬
	 *
	 * @param size �T�C�Y
	 * @param width �\���̈敝
	 * @param height �\���̈捂��
	 * @param color �V���{���J���[
	 * @return
	 */
	public static ShapeSymbol createPentagon(int size, int width, int height,
			Color color) {
		return new PentagonShape(size, width, height, color);
	}


	/**
	 * �l�p�V���{���̍쐬
	 *
	 * @param size �T�C�Y
	 * @param width �\���̈敝
	 * @param height �\���̈捂��
	 * @param color �V���{���J���[
	 * @return
	 */
	public static ShapeSymbol createRectangle(int size, int width, int height,
			Color color) {
		return new RectangleShape(size, width, height, color);
	}

	/**
	 * ���V���{���̍쐬
	 *
	 * @param size �T�C�Y
	 * @param width �\���̈敝
	 * @param height �\���̈捂��
	 * @param color �V���{���J���[
	 * @return
	 */
	public static ShapeSymbol createStar(int size, int width, int height,
			Color color) {
		return new StarShape(size, width, height, color);
	}

	/**
	 * �����_���ŃV���{�����쐬
	 *
	 * @param size �T�C�Y
	 * @param width �\���̈敝
	 * @param height �\���̈捂��
	 * @param color �V���{���J���[
	 * @return
	 */
	public static ShapeSymbol createRandom(int size, int width, int height,
			Color color) {
		ShapeSymbol shape = null;

		int random = (int) (Math.random() * 3.0);

		if (random == 0) {
			shape = createPentagon(size, width, height, color);
		} else if (random == 1) {
			shape = createRectangle(size, width, height, color);
		} else if (random == 2) {
			shape = createStar(size, width, height, color);
		} else {
			shape = createCircle(size, width, height, color);
		}

		return shape;
	}
}