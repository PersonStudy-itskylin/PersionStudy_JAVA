package cn.linkbutton;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.awt.AWTUtilities;

public class TranslucentWindow extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1172729189166171630L;

	public TranslucentWindow() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setUndecorated(true);
    	AWTUtilities.setWindowOpaque(this, false);
    	setBounds(500, 500, 300, 300);
        JPanel pane = new JPanel() {
			private static final long serialVersionUID = -4436316585226684094L;

			@Override  
            public void paint(Graphics g) {  
                super.paint(g);  
                
                g.drawImage(new ImageIcon("background.png").getImage(), 0, 0, 348, 265, this);
            }  
        };
        
        FrameListener moveListener = new FrameListener(this);
        
        addMouseListener(moveListener);
        addMouseMotionListener(moveListener);
        
        setSize(348, 265);
        setContentPane(pane);  
        setVisible(true);
    }

    public static void main(String[] args) {
        new TranslucentWindow();
    }

}