package cn.game.buildv3;

import java.awt.Graphics;

public class Playchess extends Chessboard {
	int x, y;
	boolean isheibai = true;
	Chess chess = new Chess(x, y);

	public Playchess(int x, int y) {
		// TODO 自动生成的构造函数存根
		this.x = x * 20 + 10;
		this.y = y * 20 + 100;
		// xy.setLocation(x, y);
		System.out.println(this.x + " " + this.y);
	}

	@Override
	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
		super.paint(g);

	}

}
