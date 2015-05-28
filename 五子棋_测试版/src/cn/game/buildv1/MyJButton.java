package cn.game.buildv1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyJButton extends JButton {
	private Font font;
	private String str;
	private String text;
	public MyJButton() {
		super.paint(getGraphics());
		setMargin(new Insets(0, 0, 0, 0));// 设置边距
		setContentAreaFilled(false);// 不绘制按钮区域
		setBorderPainted(false);// 不绘制边框
		setIcon(new ImageIcon("images/12.png"));// 设置默认图片
		setRolloverIcon(new ImageIcon("images/22.png"));// 设置鼠标经过图片
		setPressedIcon(new ImageIcon("images/32.png"));// 设置鼠标按下图片
		setBorder(null);
	}
	@Override
	public void setText(String text) {
		this.text = text;
	}
	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
		super.paint(g);
//		g.drawOval(10, 10, 20, 20);
		g.setColor(Color.RED);
		g.drawString(text, 50, 30);
	}
}