package cn.lin.systemtry;


import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

import cn.lin.gameboard.GameFrame;
import cn.lin.images.getImg;
import cn.lin.testing.Testing;


public class Tuopan {
	
	public Tuopan() {
		// TODO 自动生成的构造函数存根
		
	}
	/** 系统托盘图标处理. */
	public void systemTray() {
		if (SystemTray.isSupported()) { // 判断系统是否支持托盘功能.
			// URL resource = this.getClass().getResource("icon.png"); //获得图片路径
			// ImageIcon icon = new ImageIcon(resource); //创建图片对象
			ImageIcon icon = new ImageIcon(
					getImg.class.getResource("Tray.png"));
			PopupMenu popupMenu = new PopupMenu(); // 创建弹出菜单对象
			MenuItem itemExit = new MenuItem("退出系统"); // 创建弹出菜单中的退出项
			MenuItem itemShow = new MenuItem("显示窗体"); // 创建弹出菜单中的显示主窗体项.
			itemExit.addActionListener(new ActionListener() { // 给退出像添加事件监听
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			itemShow.addActionListener(new ActionListener() { // 给窗体最小化添加事件监听.
				@Override
				public void actionPerformed(ActionEvent e) {
					GameFrame.getInstance().setVisible(true);
					try {
						Testing.music.starBGMusic();
					} catch (UnsupportedAudioFileException | IOException
							| LineUnavailableException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			});
			popupMenu.add(itemShow);
			popupMenu.add(itemExit);
			TrayIcon trayIcon = new TrayIcon(icon.getImage(), "五子棋游戏",
					popupMenu);
			SystemTray sysTray = SystemTray.getSystemTray();
			try {
				sysTray.add(trayIcon);
			} catch (AWTException e1) {
			}
		}
	}
}
