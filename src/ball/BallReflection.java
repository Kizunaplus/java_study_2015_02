package ball;

/**
 * ����Java256�{�m�b�N for Java 5.0
 * Java�T���v���\�[�X ver0.2C "BallReflection"
 * BallReflection.java �u�E�B���h�E�̓����𔽎˂���{�[���v
 *
 * 2005/09/23 ����F���i�m���J�Y
 *
 * �y�R���p�C�������s���@�z
 *     >javac *.java
 *     >java BallReflection
 * �y�L�[���[�h�z
 *     ��ʂ̃��t���b�V�����[�g(refresh rate:�����������g��)
 * �y�����Ă݂悤�z
 *     �^�C�}�[�̔����Ԋu��ς��āA�A�j���[�V�����̌��������ׂ�B
 *     �E�B���h�E�̃T�C�Y��ύX�\�ɂ��A�t���[�����Œ��˕Ԃ�悤�ɂ���B
 */
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.Timer;

import ball.panel.*;
import ball.shape.*;


public class BallReflection extends JFrame {
	/**
	 * �t���[������
	 */
	private final static String FRAME_TITLE = "�A�j���[�V�����t�H�[��";

	/**
	 * �f�t�H���g�X�V�p�x
	 */
	final static int REFRESH_RATE = 30;

	/**
	 * �R���X�g���N�^
	 */
	public BallReflection() {
		AppData appData = AppData.getInstance();

		// �A�j���[�V�����\���p�l���̍쐬
		DrawPanelBase panel = new DrawPanelNormal(appData.getWidth(),
				appData.getHeight());
		if ("gravity".compareToIgnoreCase(appData.getType()) == 0) {
			panel = new DrawPanelGravity(appData.getWidth(),
					appData.getHeight());
		} else if ("wind".compareToIgnoreCase(appData.getType()) == 0) {
			panel = new DrawPanelWind(appData.getWidth(), appData.getHeight());
		}

		// �t���[���Ƀp�l����ǉ�
		this.add(panel);

		int timerTime = REFRESH_RATE;
		if (0 < appData.getWait()) {
			timerTime = appData.getWait();
		}

		new Timer(timerTime, panel).start();
	}

	/**
	 * �G���g���[�|�C���g
	 * @param args
	 */
	public static void main(String[] args) {
		ParseCommandLine(args);

		// Frame�̍쐬
		JFrame frame = new BallReflection();
		frame.setTitle(FRAME_TITLE);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBackground(Color.white);
		frame.setResizable(false);

		// Frame�̕\��
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * �R�}���h���C�����
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