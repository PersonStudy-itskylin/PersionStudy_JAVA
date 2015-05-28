package cn.lin.GUI;

import java.awt.Color;
import java.awt.PopupMenu;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import cn.lin.images.getImg;

public class PopMenu extends PopupMenu {

	/**
	 * @author Blue_Sky
	 */
	private static final long serialVersionUID = -7218207906686504458L;

	public PopMenu() {
		// TODO 自动生成的构造函数存根
		
	}
	public static JPopupMenu getPopMenu(){
		JPopupMenu jpop = new JPopupMenu();
		jpop.setBackground(new Color(0,0,0,0));
		jpop.setBorder(null);
		ImageIcon saveicon = new ImageIcon(getImg.class.getResource("popupmenu/save.jpg"));//保存棋局
		JMenuItem save = new JMenuItem("保存棋局",saveicon);
		
		ImageIcon readicon = new ImageIcon(getImg.class.getResource("popupmenu/read.png"));//打开残局
		JMenuItem read = new JMenuItem("读取残局",readicon);
		
		ImageIcon timeicon = new ImageIcon(getImg.class.getResource("popupmenu/time.png"));//打开残局
		JMenuItem time = new JMenuItem("时间设置", timeicon);
		
		jpop.add(save);
		jpop.add(read);
		jpop.add(time);
		
		
		return jpop;
	}
}
