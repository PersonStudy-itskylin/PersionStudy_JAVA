package fcg;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

public class PrintScreen {

	Robot robot = null;
	
	
	public PrintScreen() {
		// TODO �Զ����ɵĹ��캯�����
		Dimension size  = new Dimension(GameAction.height,GameAction.width);
		Rectangle rec = new Rectangle(ChessFrame.second, size);
		BufferedImage screen = robot.createScreenCapture(rec);
	}
}
