package in.ivan.button;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyJButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2057428357783615691L;
	private String text = "";

	public MyJButton(Image moren, Image press, Image click) {
		// TODO 鑷姩鐢熸垚鐨勬瀯閫犲嚱鏁板瓨鏍�
		super.paint(getGraphics());
		setMargin(new Insets(0, 0, 0, 0));// 璁剧疆杈硅窛
		setContentAreaFilled(false);// 涓嶇粯鍒舵寜閽尯鍩�
		setBorderPainted(false);// 涓嶇粯鍒惰竟妗�
		setIcon(new ImageIcon(moren));// 璁剧疆榛樿鍥剧墖
		setRolloverIcon(new ImageIcon(press));// 璁剧疆榧犳爣缁忚繃鍥剧墖
		setPressedIcon(new ImageIcon(click));// 璁剧疆榧犳爣鎸変笅鍥剧墖
		setBorder(null);
	}

	@Override
	public void setText(String text) {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		this.text = text;
	}

	public void paint(Graphics g) {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		super.paint(g);
		// g.drawOval(10, 10, 20, 20);
		g.setColor(Color.BLACK);
		g.setFont(new Font("华文行楷", Font.PLAIN, 18));
		g.drawString(text, 5, 25);
	}
}