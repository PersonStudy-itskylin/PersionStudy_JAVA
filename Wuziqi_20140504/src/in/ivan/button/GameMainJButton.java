package in.ivan.button;

import in.ivan.img.ImageJar;

import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Blue_Sky
 */
public class GameMainJButton extends MyJButton {
	private static final long serialVersionUID = -7983776885413689032L;

	public GameMainJButton() throws IOException {
		// TODO 鑷姩鐢熸垚鐨勬瀯閫犲嚱鏁板瓨鏍�
		super(ImageIO.read(ImageJar.class.getResource("button/button.png")),
				ImageIO.read(ImageJar.class
						.getResource("button/button_move.png")), ImageIO
						.read(ImageJar.class
								.getResource("button/button_click.png")));
	}
}
