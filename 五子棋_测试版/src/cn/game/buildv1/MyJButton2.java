package cn.game.buildv1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyJButton2 {

	public static void main(String[] args) {
		new frame();
	}
}

class frame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public frame() {
		setSize(400, 400);
		setLocation(400, 200);
		button bt = new button("测试");
		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(frame.this, "hah");
			}
		});
		// add(bt);
		JPanel panel = new JPanel();

		panel.add(bt);
		add(panel, BorderLayout.NORTH);
		add(new JLabel("点击圆试试"), BorderLayout.CENTER);
		this.setVisible(true);
	}
}

class button extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public button(String str) {

		super(str);

	}

	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.drawOval(0, 0, getHeight(), getHeight());
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(new Font("Arial", Font.ITALIC, getHeight() / 2));
		g2.setPaint(Color.RED);
		g2.drawString("OK ", 0, getHeight() / 2);

	}
}
