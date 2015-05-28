package cn.game.buildv3;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Chessboard extends JPanel {
	Font gametishi = new Font("宋体", Font.BOLD , 25);
	Font fontime = new Font("宋体", Font.BOLD , 12);
	Font fontime2 = new Font("宋体", Font.PLAIN , 12);
	String tishi = "";
	String time = "";
	
	public Chessboard() {
		// TODO 自动生成的构造函数存根
	}
	@Override
	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
//		BufferedImage image = null;
//		try {
//			image = ImageIO.read(Background.class.getResource("bg2.jpg"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		g.drawImage(image,1,20,this);//背景
		g.setFont(gametishi);
		g.drawString("游戏提示：" + tishi, 100, 40);
		
		g.setFont(fontime);//时间提示
		g.drawString("黑方时间:" + time , 40, 450);
		g.drawLine(30, 430, 160, 430);
		g.drawLine(30, 460, 160, 460);
		g.drawLine(30, 430, 30, 460);
		g.drawLine(160, 430, 160, 460);
		g.drawString("白方时间:" + time , 200, 450);
		g.drawLine(190, 430, 325, 430);
		g.drawLine(190, 460, 325, 460);
		g.drawLine(190, 430, 190, 460);
		g.drawLine(325, 430, 325, 460);
		//棋盘
		//	10,50	----->		370,410
		for(int i=0;i<19;i++){
			g.drawLine(10 , 50 + 20 * i , 370 , 50 + 20 * i );
			g.drawLine(10 + 20 * i , 50 , 10 + 20 * i , 410 );
		}		
		
		//定点
			g.fillOval(10 + 20 * 9 - 3 , 50 + 20 * 9 - 3 , 6, 6);
			g.fillOval(10 + 20 * 3 - 3 , 50 + 20 * 3 - 3 , 6, 6);
			g.fillOval(10 + 20 * 15 - 3 , 50 + 20 * 3 - 3 , 6, 6);
			g.fillOval(10 + 20 * 3 - 3 , 50 + 20 * 15 - 3 , 6, 6);
			g.fillOval(10 + 20 * 15 - 3 , 50 + 20 * 15 - 3 , 6, 6);
	}
}
