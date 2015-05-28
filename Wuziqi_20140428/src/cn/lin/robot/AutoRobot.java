package cn.lin.robot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Robot;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class AutoRobot extends JFrame implements Runnable{
	/**
	 * @author Blue_Sky
	 * @date 20140429
	 */
	private static final long serialVersionUID = 6915149481498778060L;
	private Robot robot;
	JProgressBar progress = new progressbar();
	
	public AutoRobot() {
		// TODO 自动生成的构造函数存根
		this.setSize(new Dimension(500,500));
		this.setLocation(new Point(200, 50));
		progress.setStringPainted(true);
		
		this.add(progress);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new AutoRobot());
		t.start();
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		for(int i = 1 ; i<101 ; i++){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			progress.setValue(i);
		}
	}
}

class progressbar extends JProgressBar{
	
	public progressbar() {
		// TODO 自动生成的构造函数存根
		super();
	}
	

	public void paint(Graphics g){
        super.paint(g);
        g.setColor(getBackground());
        g.fillRect(0,0, getWidth(), getHeight());
        
        g.setColor(getForeground());
        // drawArc(int x, int y, int width, int height, int startAngle, int arcAngle);
        g.drawArc(50, 50, 100, 100, 0, getValue()*360/getMaximum());
        g.setColor(Color.BLUE);
        g.drawArc(48, 48, 101, 101, 0, getValue()*360/getMaximum());
        g.drawArc(46, 46, 102, 102, 0, getValue()*360/getMaximum());
        g.drawArc(44, 44, 103, 103, 0, getValue()*360/getMaximum());
        g.setColor(Color.red);
        g.drawString(String.format(" %2.2f%%", 100D*getValue()/getMaximum() ), 75, 55);
    }
}
