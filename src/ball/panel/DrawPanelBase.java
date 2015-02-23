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
	 * �p�l����
	 */
	private int width = 600;

	/**
	 * �p�l������
	 */
	private int height = 400;

	/**
	 * �\���Ώۂ̃{�[��
	 */
	private List<ShapeSymbol> shapes;

	/**
	 * �R���X�g���N�^
	 */
	public DrawPanelBase(int width, int height) {
		// �w�i�F: ��
		setBackground(Color.white);

		if (0 < width) {
			this.width = width;
		}
		if (0 < height) {
			this.height = height;
		}

		// �T�C�Y
		setPreferredSize(new Dimension(this.width, this.height));

		shapes = new ArrayList<ShapeSymbol>();
		ShapeSymbol ball = ShapeFactory.createCircle(
				(int) (45.0 * Math.random() + 5), this.width, this.height,
				Color.orange);
		shapes.add(ball);
		assineMouseEvent();
	}

	/**
	 * �\���V�F�[�v���X�g�̎擾
	 */
	protected List<ShapeSymbol> getShapes() {
		return this.shapes;
	}

	/**
	 * �A�N�V�����C�x���g
	 */
	public abstract void actionPerformed(ActionEvent action);

	/**
	 * �}�E�X�N���b�N�C�x���g
	 */
	public void assineMouseEvent() {

		final List<ShapeSymbol> localShapes = this.shapes;

		// �C�x���g�̓o�^
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
	 * �`�揈��
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
