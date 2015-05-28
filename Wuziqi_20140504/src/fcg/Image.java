package fcg;

import in.ivan.img.ImageJar;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
	static BufferedImage bg = null;
	static BufferedImage BT = null;
	static BufferedImage WT = null;
	static BufferedImage Bborder = null;
	static BufferedImage Wborder = null;
	static BufferedImage close = null;
	public static int bgnum = 1;
	public static int BTnum = 1;
	public static int WTnum = 1;
	public static Image img = new Image();

	private Image() {
		// TODO Auto-generated constructor stub

	}

	public static Image getInstance() {
		try {
			bg = ImageIO.read(ImageJar.class.getResource("bg/bg" + bgnum
					+ ".jpg"));
			BT = ImageIO.read(ImageJar.class.getResource("Tpic/T" + BTnum
					+ ".jpg"));
			WT = ImageIO.read(ImageJar.class.getResource("Tpic/T" + WTnum
					+ ".jpg"));
			Bborder = ImageIO.read(ImageJar.class.getResource("Bborder.jpg"));
			Wborder = ImageIO.read(ImageJar.class.getResource("Wborder.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}

	// ±³¾°Í¼Æ¬
	public void setbg(int num) {
		bgnum = num;
	}

	public BufferedImage getbg() {
		return bg;
	}

	// ºÚ·½Í·Ïñ
	public void setBT(int num) {
		BTnum = num;
	}

	public BufferedImage getBT() {
		return BT;
	}

	// °×·½Í·Ïñ
	public void setWT(int num) {
		BTnum = num;
	}

	public BufferedImage getWT() {
		return WT;
	}

	public BufferedImage getBborder() {
		return Bborder;
	}

	public BufferedImage getWborder() {
		return Wborder;
	}

	public BufferedImage getClose() {
		return close;
	}
}
