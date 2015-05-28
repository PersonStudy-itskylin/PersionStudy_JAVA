package cn.lin.GUI;

import java.awt.Dimension;
import java.awt.Toolkit;

 
	public class ScreanSizeUtil {
		public static Dimension scrSize;
		 static{
			if (scrSize == null) {
				scrSize = getDimension();
			}
		}

		public static Dimension getDimension() {
			scrSize = Toolkit.getDefaultToolkit().getScreenSize();
			return scrSize;
		}

		public static int getWidth() {
			return (int) scrSize.getWidth();
		}

		public static int getHetgth() {
			return (int) scrSize.getHeight();
		}

	}