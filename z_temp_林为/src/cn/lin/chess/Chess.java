package cn.lin.chess;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import cn.lin.action.GameAction;
import cn.lin.images.getImg;
import cn.lin.player.Player;


public class Chess {
	public static Chess chess = new Chess();
	private BufferedImage black;
	private BufferedImage white;
	private Point point = new Point(-100, -100);
	public static int chessNum = 0;

	// ˽�й��췽��
	private Chess() {
		try {
			black = ImageIO.read(getImg.class.getResource("black.jpg"));
			white = ImageIO.read(getImg.class.getResource("white.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Chess getInstance() {
		return chess;
	}

	// �������
	public Point getPoint() {
		return point;
	}

	// �������
	public boolean setPoint(Point p) {
		if (point.x == p.x && point.y == p.y) {
			return false;
		} else {
			this.point = p;
			chessNum++;
			return true;
		}

	}

	// ��������ͼƬ
	public BufferedImage getChess(Player player) {
		if (player == GameAction.B)
			return black;
		else
			return white;
	}

	// ��ȡ������ɫ
	public int getColor(Player player) {
		if (GameAction.B.isPlay())
			return 1;
		else
			return 2;
	}
}
