package cn.lin.GUI;

import java.io.IOException;

import javax.swing.JButton;

import cn.lin.Button.GameExit;
import cn.lin.Button.GameMainJButton;
import cn.lin.Button.GameMin;
import cn.lin.chessboard.ChessBoard;

public class UIManager{
	private static int BUTTON_LEFT1 = 35;
	private static int BUTTON_LEFT2 = 115;
	private static int BUTTON_TOP = 200;
	private static int BUTTON_SIZE = 80;
	public JButton start;
	public JButton huiqi;
	public JButton mode;
	public JButton music;
	public JButton background;
	public JButton message;
	public JButton video;
	public JButton version;
	public JButton min;
	public JButton exit;

	public UIManager() {
		// TODO 自动生成的构造函数存根
		try {
			start = new GameMainJButton();
			huiqi = new GameMainJButton();
			mode = new GameMainJButton();
			music = new GameMainJButton();
			message = new GameMainJButton();
			
			video = new GameMainJButton();
			background = new GameMainJButton();
			version = new GameMainJButton();
			min = new GameMin();
			exit = new GameExit();
		} catch (IOException e) {
			// TODO 自动生成的 catch块
			e.printStackTrace();
		}
		start.setText("开始");
		mode.setText("模式");
		huiqi.setText("悔棋");
		music.setText("音乐");
		background.setText("背景");
		version.setText("关于");
		
		min.setBounds(ChessBoard.CHESSBOARD_WIDTH - 80, 20, 30, 30);
		exit.setBounds(ChessBoard.CHESSBOARD_WIDTH - 50, 20, 30, 30);

		/*****************************第一列按钮************************************/
		start.setBounds(BUTTON_LEFT1, BUTTON_TOP + BUTTON_SIZE, BUTTON_SIZE,
				BUTTON_SIZE);
		mode.setBounds(BUTTON_LEFT1, BUTTON_TOP + BUTTON_SIZE * 2,
				BUTTON_SIZE, BUTTON_SIZE);
		huiqi.setBounds(BUTTON_LEFT1, BUTTON_TOP + BUTTON_SIZE * 3,
				BUTTON_SIZE, BUTTON_SIZE);
		/*****************************第二列按钮************************************/
		music.setBounds(BUTTON_LEFT2, BUTTON_TOP + BUTTON_SIZE ,
				BUTTON_SIZE, BUTTON_SIZE);
		background.setBounds(BUTTON_LEFT2, BUTTON_TOP + BUTTON_SIZE * 2,
				BUTTON_SIZE, BUTTON_SIZE);
		version.setBounds(BUTTON_LEFT2, BUTTON_TOP + BUTTON_SIZE * 3, BUTTON_SIZE,
				BUTTON_SIZE);
	}

}
