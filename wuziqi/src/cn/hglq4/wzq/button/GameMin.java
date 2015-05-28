package cn.hglq4.wzq.button;

import java.io.IOException;

import javax.imageio.ImageIO;

import cn.hglq4.wzq.img.ImageJar;

public class GameMin extends MyJButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6786787211433201501L;

	public GameMin() throws IOException {
		// TODO 自动生成的构造函数存�?
		super(ImageIO.read(ImageJar.class.getResource("min/min_move.png")),
				ImageIO.read(ImageJar.class.getResource("min/min.png")),
				ImageIO.read(ImageJar.class.getResource("min/min_click.png")));
	}
}
