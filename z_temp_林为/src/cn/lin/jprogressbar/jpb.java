package cn.lin.jprogressbar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;

public class jpb extends JProgressBar {

	public jpb() {
		// TODO 自动生成的构造函数存根
		super();
		this.setBorder(null);
	}

	public void paint(Graphics g) {
		// super.paint(g);
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());

		g.setColor(getForeground());
//		 drawArc(int x, int y, int width, int height, int startAngle, int
//		 arcAngle);
		g.fillArc(50, 0, 100, 100, 0, getValue() * 360 / getMaximum());
		g.setColor(Color.red);
		g.drawString(
				String.format("%2.0f%%", 100D * getValue() / getMaximum()), 83,
				55);
	}

}

class testing22 extends JFrame implements Runnable{

	private jpb jpb;

	public testing22() {
		// TODO 自动生成的构造函数存根
		this.setSize(200, 200);
		this.setUndecorated(true);
		this.setBackground(new Color(0,0,0,0));
		
		jpb = new jpb();
		jpb.setMaximum(100);
		jpb.setMinimum(0);
		
		this.add(jpb);
		RenderingHints rrh = new RenderingHints(null);
//		rrh.
//		JToggleButton jtb = new JToggleButton("Testing");
//		jtb.setBounds(50, 100, 30, 20);
//		this.setLayout(null);
//		this.add(jtb);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new testing22());
		t.start();
	}
	
	@Override
	public void run() {
		// TODO 自动生成的方法<存根
		for(int i = 1 ; i<100000000;i++){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			jpb.setValue(i%100);
		}
	}
	
}