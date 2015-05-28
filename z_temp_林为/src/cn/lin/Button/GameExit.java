package cn.lin.Button;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import cn.lin.images.getImg;

public class GameExit extends MyJButton {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6786787211433201501L;

	
	public GameExit() throws IOException {
		// TODO 自动生成的构造函数存根
		super(ImageIO.read(getImg.class.getResource("exit/exit_move.png")), ImageIO
				.read(getImg.class.getResource("exit/exit.png")), ImageIO
				.read(getImg.class.getResource("exit/exit_click.png")));
	}
}
