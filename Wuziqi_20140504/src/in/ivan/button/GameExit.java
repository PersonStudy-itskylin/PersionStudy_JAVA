package in.ivan.button;

import in.ivan.img.ImageJar;

import java.io.IOException;

import javax.imageio.ImageIO;

public class GameExit extends MyJButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6786787211433201501L;

	public GameExit() throws IOException {
		// TODO 自动生成的构造函数存根
		super(ImageIO.read(ImageJar.class.getResource("exit/exit_move.png")),
				ImageIO.read(ImageJar.class.getResource("exit/exit.png")),
				ImageIO.read(ImageJar.class.getResource("exit/exit_click.png")));
	}
}
