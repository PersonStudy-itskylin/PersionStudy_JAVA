package cn.hglq4.wzq.clazz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class About extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9079552224677683602L;
	private BufferedImage bg;



	public About() {
		// TODO 自动生成的构造函数存�?
		this.setSize(901,570);
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(0,0,0,0));
		this.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO 自动生成的方法存�?
		super.paint(g);
		URL bgurl = AI.class.getResource("dialog.png");
		try {
			bg = ImageIO.read(bgurl);
		} catch (IOException e) {
			// TODO 自动生成�?catch �?
			e.printStackTrace();
		}
		
		g.drawImage(bg,0,0,this);
		repaint();
		
	}
}
