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
import java.awt.Polygon;

public class PentagonShape extends ShapeSymbol {
	/**
	 * �R���X�g���N�^
	 */
	public PentagonShape(int size, int width, int height, Color color) {
		super(size, width, height, color);
	}

	/**
	 * �{�[���̕`��
	 */
	public void draw(Graphics grapchic) {
		grapchic.setColor(this.getColor());

		int r = this.getSize() / 2;
		int t, x, y;

		Polygon p = new Polygon();
		for (t = 90; t < 450; t += 360 / 5) {
			x = (int) (r * Math.cos(t * Math.PI / 180) + (this.getX() + r) + 0.5);
			y = (int) (-r * Math.sin(t * Math.PI / 180) + (this.getY() + r) + 0.5);
			p.addPoint(x, y);
		}
		grapchic.fillPolygon(p);
	}
}