package ball.panel;

/**
 * ����Java256�{�m�b�N for Java 5.0
 * Java�T���v���\�[�X ver0.2C "BallReflection"
 * DrawPanel.java �u�E�B���h�E�̓����𔽎˂���{�[���v
 *
 * 2005/09/23 ����F���i�m���J�Y
 *
 * �y�R���p�C�������s���@�z
 *     >javac *.java
 *     >java BallReflection
 * �y�L�[���[�h�z
 *     �C�x���g�쓮(event-driven)�v���O����, �R���|�[�l���g�̍ĕ`��(repaint), 
 *     �R�[���o�b�N(callback)���\�b�h,
 *     �C�x���g�f�B�X�p�b�`�X���b�h(event dispatch thread), 
 * �y�����Ă݂悤�z
 *     �{�[���̐��𑝂₵�Ĕz��ŊǗ�����B
 */
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import ball.shape.*;

public class DrawPanelWind extends DrawPanelBase {
	
	/**
	 * ���̐�������
	*/
	private final int WIND_COUNT = 500;
	
	/**
	 * ���������Ă��鎞��
	*/
	private int windTime = 0;

	/**
	 * �R���X�g���N�^
	 */
	public DrawPanelWind(int width, int height) {
		super(width, height);
	}

	/**
	 * �A�N�V�����C�x���g
	 */
	public void actionPerformed(ActionEvent action) {
		Dimension size = getPreferredSize();
		double wind = 5 * Math.random();
		windTime++;
		if (windTime / WIND_COUNT % 2 == 1) {
			// �����̏ꍇ�́A�����~��
			wind = 0;
		}
		
		
		if (windTime / WIND_COUNT % 4 == 0) {
			// 4�̔{���ꍇ�́A�t�̕�������
			wind *= -1;
		}

		for (ShapeSymbol ball : this.getShapes()) {
			ball.action(wind, 0);

			// �ǂɏՓ˂���Δ���
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