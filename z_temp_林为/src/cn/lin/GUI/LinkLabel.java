package cn.lin.GUI;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LinkLabel extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1710956017586890169L;
	private String text, url;
	private boolean isSupported;

	public LinkLabel(String text, String url) {
		this.text = text;
		this.url = url;
		this.setFont(new Font("宋体", Font.PLAIN, 15));
		try {
			this.isSupported = Desktop.isDesktopSupported()
					&& Desktop.getDesktop().isSupported(Desktop.Action.BROWSE);
		} catch (Exception e) {
			this.isSupported = false;
		}
		setText(false);
		addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setText(isSupported);
				if (isSupported)
					setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				setText(false);
			}

			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI(LinkLabel.this.url));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}

	private void setText(boolean b) {
		if (!b)
			setText("<html><font color=blue><u>" + text);
		else
			setText("<html><font color=red><u>" + text);
	}

	/*public static void main(String[] args) {
		JFrame jf = new JFrame("一个超链接实现的例子-志文工作室");
		JPanel jp = new JPanel();
		jp.add(new LinkLabel(
				"403415171",
				"http://sighttp.qq.com/authd?IDKEY=6ea5693cb859d8cefb6459a274b2c059703e3fea14483437"));
		jf.setContentPane(jp);
		jf.pack();
		jf.setVisible(true);
	}*/
}