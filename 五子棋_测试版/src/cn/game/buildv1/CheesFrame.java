package cn.game.buildv1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.image.Background;

public class CheesFrame extends JFrame implements MouseListener {
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 3260618937490003212L;
	Font gametishi = new Font("宋体", Font.BOLD, 25);
	Font fontime = new Font("宋体", Font.PLAIN, 15);
	int x = 0, y = 0;
	int tempX = 0, tempY = 0;
	int[][] Chees = new int[19][19];// 0:鏃犲瓙 1锛氶粦瀛� 2锛氱櫧瀛�
	boolean isheibai = true;
	boolean winflag = true;
	String tishi = "";
	boolean play = false;
	int times;

	public CheesFrame() {
		setTitle("五子棋—人人对战");
		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// repaint();
		this.addMouseListener(this);
	}

	@Override
	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
		super.paint(g);
		BufferedImage image = null;
		try {
			image = ImageIO.read(Background.class.getResource("bg2.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(image, 1, 20, this);// 背景
		g.setFont(gametishi);
		g.drawString("游戏提示：" + tishi, 100, 60);

		g.setFont(fontime);// 时间提示
		g.drawString("黑方时间:", 35, 470);
		g.drawString("白方时间:", 255, 470);
		// 棋盘
		for (int i = 0; i < 19; i++) {
			g.drawLine(10, 70 + 20 * i, 370, 70 + 20 * i);
			g.drawLine(10 + 20 * i, 70, 10 + 20 * i, 430);
		}

		// 定点
		g.fillOval(10 + 20 * 9 - 3, 70 + 20 * 9 - 3, 6, 6);
		g.fillOval(10 + 20 * 3 - 3, 70 + 20 * 3 - 3, 6, 6);
		g.fillOval(10 + 20 * 15 - 3, 70 + 20 * 3 - 3, 6, 6);
		g.fillOval(10 + 20 * 3 - 3, 70 + 20 * 15 - 3, 6, 6);
		g.fillOval(10 + 20 * 15 - 3, 70 + 20 * 15 - 3, 6, 6);

		// System.out.println(play);
		if (play) {

			if (isheibai == true) {
				// 绘制 黑色棋子

				g.fillOval(10 + 20 * tempX - 7, 70 + 20 * tempY - 7, 14, 14);

			} else {
				// 绘制 白色棋子

				g.setColor(Color.WHITE);
				g.fillOval(10 + 20 * tempX - 7, 70 + 20 * tempY - 7, 14, 14);
				g.setColor(Color.BLACK);
				g.drawOval(10 + 20 * tempX - 7, 70 + 20 * tempY - 7, 14, 14);
			}

			for (int i = 0; i < 19; i++) {// 绘制 全部棋子
				for (int j = 0; j < 19; j++) {
					if (Chees[i][j] == 1) {
						// 绘制 黑色棋子
						g.setColor(Color.BLACK);
						g.fillOval(10 + 20 * i - 7, 70 + 20 * j - 7, 14, 14);
					}
					if (Chees[i][j] == 2) {
						// 绘制 白色棋子
						g.setColor(Color.WHITE);
						g.fillOval(10 + 20 * i - 7, 70 + 20 * j - 7, 15, 15);
						g.setColor(Color.BLACK);
						g.drawOval(10 + 20 * i - 7, 70 + 20 * j - 7, 14, 14);
					}

				}
			}
		}// play

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		x = e.getX();
		y = e.getY();
		System.out.println("x= " + x + " y=" + y);


		// 版本信息
		if ((x >= 400 && x <= 470) && (y >= 310 && y <= 335)) {
			String str = "游戏版本:    Bluid v0.0.0.1\n      作  者:      幽蓝\n  联系QQ:     403415171\n           版权所有，翻版不究！";
			JOptionPane.showMessageDialog(null, str, "关于游戏",
					JOptionPane.PLAIN_MESSAGE, null);
		}

		// 时间设置
		if ((x >= 400 && x <= 470) && (y >= 140 && y <= 160)) {
			times = Integer.parseInt(JOptionPane.showInputDialog(this,
					"请输入时间（以秒（s）为单位,\n输入 “ 0 ” 表示时间无限制）：", "60"));
		}
		// 退出
		if ((x >= 400 && x <= 470) && (y >= 360 && y <= 380)) {
			x = -500;
			y = -500;
			int exit = JOptionPane.showConfirmDialog(this, "确定要退出吗？", "退出提示：",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (exit == 0) {
				System.exit(0);
			} else {
				JOptionPane.showMessageDialog(this, "你他妈的原来不想退出啊？？",
						JOptionPane.OPTIONS_PROPERTY, JOptionPane.OK_OPTION);
			}
		}

		// 系统设置
		if ((x >= 400 && x <= 470) && (y >= 175 && y <= 200)) {
			// x =-500;
			// y = -500;
			JOptionPane.showMessageDialog(this, "你点的是系统设置");
		}

		// 认输
		if ((x >= 400 && x <= 470) && (y >= 270 && y <= 295)) {
			// x =-500;
			// y = -500;
			String heiorbai = (isheibai == true ? "黑方" : "白方");
			int gameover = JOptionPane.showConfirmDialog(this, heiorbai
					+ "确定要认输吗？", "认输提示：", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根

		//
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	public boolean WinFlag(int x, int y, int color) {
		boolean flag = false;
		int count = 1;
		int i = 1;
		int a = tempX;
		int b = tempY;
		count = 1;
		a = tempX + 1;
		b = tempY;

		// 纵向
		for (i = 1; i <= 4; i++, a++) {
			if (a >= 0 && a <= 18 && b >= 0 && b <= 18) {
				if (Chees[a][b] == color) {
					count++;
				} else {
					break;
				}
			}
		}

		a = tempX - 1;
		for (i = 1; i <= 4; i++, a--) {
			if (a >= 0 && a <= 18 && b >= 0 && b <= 18) {
				if (Chees[a][b] == color) {
					count++;
				} else {
					break;
				}
			}
		}
		// System.out.println("横向  " + count);
		if (count >= 5) {
			flag = true;
		}

		count = 1;
		a = tempX;
		b = tempY + 1;
		// 横向
		for (i = 1; i <= 4; i++, b++) {
			if (a >= 0 && a <= 18 && b >= 0 && b <= 18) {
				if (Chees[a][b] == color) {
					count++;
				} else {
					break;
				}
			}
		}
		b = tempY - 1;
		for (i = 1; i <= 4; i++, a--) {
			if (a >= 0 && a <= 18 && b >= 0 && b <= 18) {
				if (Chees[a][b] == color) {
					count++;
				} else {
					break;
				}
			}
		}
		// System.out.println("纵向  " + count);
		if (count >= 5) {
			flag = true;
		}

		count = 1;
		a = tempX + 1;
		b = tempY + 1;
		// 左上右下
		for (i = 1; i <= 4; i++, a++, b++) {
			if (a >= 0 && a <= 18 && b >= 0 && b <= 18) {
				if (Chees[a][b] == color) {
					count++;
				} else {
					break;
				}
			}
		}
		a = tempX - 1;
		b = tempY - 1;
		for (i = 1; i <= 4; i++, a--, b--) {
			if (a <= 18 && a >= 0 && b >= 0 && b <= 18) {
				if (Chees[a][b] == color) {
					count++;
				} else {
					break;
				}
			}
		}
		// 、 System.out.println("斜向  " + count);
		if (count >= 5) {
			flag = true;
		}

		count = 1;
		a = tempX + 1;
		b = tempY - 1;
		// 左下右上
		for (i = 1; i <= 4; i++, a++, b--) {
			if (a >= 0 && a <= 18 && b >= 0 && b <= 18) {
				if (Chees[a][b] == color) {
					count++;
				} else {
					break;
				}
			}
		}
		System.out.println("左下        " + count);
		a = tempX - 1;
		b = tempY + 1;
		for (i = 1; i <= 4; i++, a--, b++) {
			if (a <= 18 && a >= 0 && b >= 0 && b <= 18) {
				if (Chees[a][b] == color) {
					count++;
				} else {
					break;
				}
			}
		}
		System.out.println("右上  " + count);
		if (count >= 5) {
			flag = true;
		}

		return flag;
	}

}
