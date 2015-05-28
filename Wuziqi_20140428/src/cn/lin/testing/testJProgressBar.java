package cn.lin.testing;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import cn.lin.images.getImg;

public class testJProgressBar extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 49504037963415098L;
	private JLabel jlback = null;

	public testJProgressBar() {
		setSize(600, 600);
		 setUndecorated(true);
		 jlback = new JLabel();
		 jlback.setOpaque(true);
		 add(jlback);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		Graphics g = getGraphics();
		BufferedImage backimg = null;
			for (int i = 0; i < 25; i++) {
				try {
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					backimg = ImageIO.read(getImg.class
							.getResource("loading/loading" + i + ".png"));
					ImageIcon image = new ImageIcon(backimg);
					jlback = new JLabel(image);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				g.drawImage(backimg, 50, 50, this);
			}
	}

	public static void main(String[] args) {
		Thread t = new Thread(new testJProgressBar());
		t.start();
	}
}
