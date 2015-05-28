package cn.lin.Button;

import java.io.IOException;

import javax.imageio.ImageIO;

import cn.lin.images.getImg;

/**
 * @author Blue_Sky
 */
public class GameMainJButton extends MyJButton {
	private static final long serialVersionUID = -7983776885413689032L;

	public GameMainJButton() throws IOException {
		// TODO 自动生成的构造函数存根
		super(ImageIO.read(getImg.class.getResource("button/button.png")), ImageIO
				.read(getImg.class.getResource("button/button_move.png")), ImageIO
				.read(getImg.class.getResource("button/button_enter.png")));
	}
}
