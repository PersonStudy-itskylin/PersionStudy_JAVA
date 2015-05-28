package cn.game.buildv3;

import javax.swing.JFrame;

public class Chess_Frame extends JFrame{
	
	public void Chess_UI() {
		// TODO 自动生成的构造函数存根
		this.setSize( 550 , 550 );
		this.setTitle("五子棋");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(new Chessboard());
	}
}
