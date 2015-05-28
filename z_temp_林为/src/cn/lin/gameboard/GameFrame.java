package cn.lin.gameboard;

import java.awt.Color;

import javax.swing.JFrame;

import cn.lin.chessboard.ChessBoard;
import cn.lin.systemtry.Tuopan;

public class GameFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6500062816501235288L;
	public static GameFrame gameframe = new GameFrame();

	public static GameFrame getInstance() {
		return gameframe;
	}

	private GameFrame() {
		// TODO 自动生成的构造函数存根
		add(ChessBoard.getInstance());
		setSize(938, 600);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		setLocationRelativeTo(null);
		setVisible(true);
		
		new Tuopan().systemTray();
	}

}
