package cn.lin.Button;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import cn.lin.images.getImg;

public class MyJButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2057428357783615691L;
	private String text ="";

	public MyJButton(Image moren,Image press,Image click) {
		// TODO 自动生成的构造函数存根
		super.paint(getGraphics());
		setMargin(new Insets(0, 0, 0, 0));// 设置边距
		setContentAreaFilled(false);// 不绘制按钮区域
		setBorderPainted(false);// 不绘制边框
		setIcon(new ImageIcon(moren));// 设置默认图片
		setRolloverIcon(new ImageIcon(press));// 设置鼠标经过图片
		setPressedIcon(new ImageIcon(click));// 设置鼠标按下图片
		setBorder(null);
	}

	@Override
	public void setText(String text) {
		// TODO 自动生成的方法存根
		this.text = text;
	}

	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
		super.paint(g);
		// g.drawOval(10, 10, 20, 20);
		g.setColor(Color.BLACK);
		g.setFont(new Font("迷你简黄草", Font.PLAIN, 22));
		g.drawString(text, 22, 50);
	}
}