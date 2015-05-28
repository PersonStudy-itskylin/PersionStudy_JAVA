package fcg;

import in.ivan.img.ImageJar;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GameFrame extends JFrame {
	/**
	 * @author Blue_Sky
	 * @date 2014-04-28
	 */
	private static final long serialVersionUID = 8200604481553132730L;
	private BufferedImage icon = null;
	public static GameFrame gameFrame = new GameFrame();

	public static GameFrame getIntance() {
		return gameFrame;
	}

	private GameFrame() {
		// TODO Auto-generated constructor stub

		setSize(GameAction.height, GameAction.width);
		// setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			icon = ImageIO.read(ImageJar.class.getResource("icon.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setIconImage(icon);
		setUndecorated(true);

		// ÃÌº”∆Â≈Ã
		add(ChessFrame.getInstance());
		setVisible(true);

	}

}
