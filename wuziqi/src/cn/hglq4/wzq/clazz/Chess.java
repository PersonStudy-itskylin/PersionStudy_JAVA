package cn.hglq4.wzq.clazz;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import cn.hglq4.wzq.img.ImageJar;
/**
 * 
 * @author Blue_Sky
 *
 */
public class Chess {
	public static Chess chess = new Chess();
	// public static Chess Wchess=new Chess();
	private BufferedImage black;
	private BufferedImage white;
	private Point point = new Point(-100, -100);
	public static int chessNum = 0;

	// ˽�й��췽��
	private Chess() {
		try {
			black = ImageIO.read(ImageJar.class.getResource("black.jpg"));
			white = ImageIO.read(ImageJar.class.getResource("white.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Chess getInstance() {
		return chess;
	}

	// ��������
	public Point getPoint() {
		return point;
	}

	// ��������
	public boolean setPoint(Point p) {
		if (point.x == p.x && point.y == p.y) {
			// System.out.println("NONO");
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
