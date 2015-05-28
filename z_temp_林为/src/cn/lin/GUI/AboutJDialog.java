package cn.lin.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JLabel;

import cn.lin.chessboard.ChessBoard;
import cn.lin.images.getImg;

public class AboutJDialog extends JDialog implements MouseListener,MouseMotionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3525552836140216957L;
	public static AboutJDialog about=new AboutJDialog();
	private Point top;
	private Point first;
	private Point second;
	private boolean drag = false;
	UIManager ui = new UIManager();
	JLabel link = new LinkLabel(
			"403415171",
			"http://sighttp.qq.com/authd?IDKEY=6ea5693cb859d8cefb6459a274b2c059703e3fea14483437");
	
	public static AboutJDialog getInstance(){
		return about;
	}
	
	
	private AboutJDialog() {
		// TODO 自动生成的构造函数存根
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		setSize(300,200);
		setLocationRelativeTo(ChessBoard.getInstance());

		ui.exit.setBounds(250, 15, 50, 30);
		add(ui.exit);
		setLayout(null);
		link.setBounds(140, 85, 100, 30);
		add(link);
		
//		setModal(true);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setVisible(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		ui.exit.addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO 自动生成的方法存根
		super.paint(g);
		BufferedImage aboutPic=null;
		try {
			aboutPic=ImageIO.read(getImg.class.getResource("dialog.png"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		g.drawImage(aboutPic, 0, 0, 300, 190,this);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(drag){
			second=e.getLocationOnScreen();
			this.setLocation(top.x+(second.x-first.x),top.y+(second.y-first.y));
		}
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource() == ui.exit){
			this.setVisible(false);
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		top=this.getLocationOnScreen();
		first=e.getLocationOnScreen();
		drag=true;
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