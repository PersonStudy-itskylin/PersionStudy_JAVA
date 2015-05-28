package cn.lin.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JDialog;

import cn.lin.images.getImg;

public class Jdialog extends JDialog {
	
	private BufferedImage bg;



	public Jdialog() {
		// TODO 自动生成的构造函数存根
		this.setSize(901,570);
		this.setTitle("关于...");
		
		this.setUndecorated(true);
		this.setBackground(new Color(0,0,0,0));
		this.setVisible(true);
	}
	
	
	
	@Override
	public void paintComponents(Graphics g) {
		// TODO 自动生成的方法存根
		URL bgurl = getImg.class.getResource("dialog.png");
		try {
			bg = ImageIO.read(bgurl);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		g.drawImage(bg,0,0,this);
		
	}
}
