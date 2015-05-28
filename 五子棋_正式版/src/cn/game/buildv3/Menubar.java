package cn.game.buildv3;

import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Menubar  extends JMenu{
	JMenuBar jmb = new JMenuBar();
	JMenu start = new JMenu("游戏(G)");
	JMenuItem start1 = new JMenuItem("简单"); 
	JMenuItem start2 = new JMenuItem("普通"); 
	JMenuItem start3 = new JMenuItem("困难"); 
	JMenu setting = new JMenu("设置(S)");
	JMenuItem sgame = new JMenuItem("游戏设置");
	JMenuItem smusic = new JMenuItem("音效");
	JMenuItem sbackground = new JMenuItem("背景图片");
	JMenu version = new JMenu("关于(V)");
	JMenuItem vhelp = new JMenuItem("游戏帮助");
	JMenuItem vver = new JMenuItem("关于...");
	Font font = new Font("宋体", Font.PLAIN , 15 );
	public	JMenuBar Menu() {
		// TODO 自动生成的构造函数存根
		
		/*
		 * 菜单的字体
		 */
		start.setFont(font);
		start1.setFont(font);
		start2.setFont(font);
		start3.setFont(font);
		setting.setFont(font);
		sgame.setFont(font);
		smusic.setFont(font);
		sbackground.setFont(font);
		version.setFont(font);
		vhelp.setFont(font);
		vver.setFont(font);
		
		/*
		 * 快捷键的设置
		 */
		start.setMnemonic('A');
		setting.setMnemonic('S');
		version.setMnemonic('V');
//		start1.setAccelerator( Keys);
		start1.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_1 , InputEvent.ALT_MASK));
		start2.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_2 , InputEvent.ALT_MASK));
		start3.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_3 , InputEvent.ALT_MASK));
		sgame.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_K , InputEvent.ALT_MASK));		
		sbackground.setAccelerator(  KeyStroke.getKeyStroke( KeyEvent.VK_P , InputEvent.ALT_MASK));
		smusic.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_M , InputEvent.ALT_MASK));
		vhelp.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_H , InputEvent.ALT_MASK));
		vver.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_O , InputEvent.ALT_MASK));
		
		
		/*
		 * 菜单的组合
		 */
		jmb.add(start);
		start.add(start1);
		start.add(start2);
		start.add(start3);
		jmb.add(setting);
			setting.add(sgame);
			setting.add(smusic);
			setting.add(sbackground);
		jmb.add(version);
			version.add(vhelp);
			version.add(vver);
		
		return jmb;
	}
}
