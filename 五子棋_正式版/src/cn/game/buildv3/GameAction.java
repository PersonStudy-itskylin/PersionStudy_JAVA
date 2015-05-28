package cn.game.buildv3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;


public class GameAction extends Chess_Frame implements MouseListener, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5030661910651763738L;
	Menubar menu = new Menubar();
	int x,y;
	
	public GameAction() {
		// TODO 自动生成的构造函数存根
		Chess_UI();
		this.setJMenuBar(menu.Menu());
		
		this.addMouseListener(this);
		
		
//		menu.start.addActionListener(this);
//		menu.setting.addActionListener(this);
//		menu.version.addActionListener(this);
		menu.start2.addActionListener(this);
		menu.start3.addActionListener(this);
		menu.sgame.addActionListener(this);
		menu.smusic.addActionListener(this);
		menu.sbackground.addActionListener(this);
		menu.vhelp.addActionListener(this);
		menu.vver.addActionListener(this);
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource() == menu.vver){
			String str = "游戏版本:        Bluid v0.0.0.1\n      作  者:      幽蓝\n  联系QQ:     403415171\n版权所有，请勿用于商业！";
			JOptionPane.showMessageDialog(this, str,"关于游戏", JOptionPane.PLAIN_MESSAGE, null);
		}
		if(e.getSource() == menu.vhelp){
			JOptionPane.showMessageDialog(this, "你选择的是帮助");
		}
		if(e.getSource() == menu.sbackground){
			JOptionPane.showMessageDialog(this, "你选择的是设置背景");
		}
		if(e.getSource() == menu.smusic){
			JOptionPane.showMessageDialog(this, "你选择的是音效设置");
		}
		if(e.getSource() == menu.start1){
			JOptionPane.showMessageDialog(this, "你选择的是简单级别游戏");
		}
		if(e.getSource() == menu.start2){
			JOptionPane.showMessageDialog(this, "你选择的是普通级别游戏");
		}
		if(e.getSource() == menu.start3){
			JOptionPane.showMessageDialog(this, "你选择的是困难级别游戏");
		}
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		x = e.getX();
		y = e.getY();
		if( ( x > 5 && x < 380 ) && ( y > 90 && y < 470 ) ){
			System.out.println(x + " " + y);
				x = ( x - 5 ) / 20 ;
				y = (y - 90 ) / 20 ;
				Playchess play = new Playchess(x, y);
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
