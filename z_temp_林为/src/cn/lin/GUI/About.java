package cn.lin.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.lin.images.getImg;

public class About extends JDialog {

	public static About about=new About();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9079552224677683602L;
	JLabel link = new LinkLabel(
			"403415171",
			"http://sighttp.qq.com/authd?IDKEY=6ea5693cb859d8cefb6459a274b2c059703e3fea14483437");
	private AboutJpanel jp;

	public static About getInstance(){
		return about;
	}
	
	private About() {
		// TODO 自动生成的构造函数存�?
		this.setSize(1366, 768);
		this.setLocation(0,0);
		this.setBackground(Color.BLUE);
		this.setUndecorated(true);
		this.setBackground(new Color(0, 0, 0, 0));
		
		jp = new AboutJpanel();
		jp.add(link);
		link.setBounds(AboutJpanel.locx+140,AboutJpanel.locx+90, 100, 30);
		jp.setLayout(null);
		this.add(jp);
		this.setModal(true);
		this.setVisible(true);
		
	}

}

class AboutJpanel extends JPanel implements MouseListener,MouseMotionListener {
	/**
	 * @author Blue_Sky
	 */
	private static final long serialVersionUID = 7598255585583609331L;
	private BufferedImage bg;
	public static int locx=0;
	public static int locy=0;
	
	private Point top = new Point(50,50);
	private Point first = new Point();
	private Point second = new Point();
	private boolean drag = false;

	Point loc = null;

    Point tmp = null;

    boolean isDragged = false;

	
	/**
	 * 
	 */
	public AboutJpanel() {
		// TODO 自动生成的构造函数存根
		setLocation(locx, locy);
		this.setOpaque(false);
		this.setBackground(new Color(0,0,0,0));
		
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO 自动生成的方法存根
		URL bgurl = getImg.class.getResource("dialog.png");
		try {
			bg = ImageIO.read(bgurl);
		} catch (IOException e) {
			// TODO 自动生成�?catch �?
			e.printStackTrace();
		}
		g.drawImage(bg, 0, 0, this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自动生成的方法存根
		if (drag) {
			second = e.getLocationOnScreen();
			System.out.println(second.x+"完成 拖拽"+second.y);
			this.setLocation(second.x - first.x + top.x,
					second.y - first.y + top.y);
			locx=second.x - first.x + top.x;
			locy=second.y - first.y + top.y;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		int x=e.getX();
		int y=e.getY();
		if (x <= 300 && y <= 200) {
			top= this.getLocationOnScreen();
			first = e.getLocationOnScreen();
			drag = true;
			System.out.println(top.x+" top "+top.y);
			System.out.println(first.x+" first "+first.y);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

}
