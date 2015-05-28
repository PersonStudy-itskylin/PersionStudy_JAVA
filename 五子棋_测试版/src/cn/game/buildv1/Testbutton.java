package cn.game.buildv1;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;

public class Testbutton extends JFrame {
	private MyJButton btn, btn_2;
	private MyJButton btn_3, btn_4, btn_5;

	public Testbutton() {
		super();
		setTitle("JButtonTest");
		setSize(500, 500);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.YELLOW);
		btn = new MyJButton();
		btn.setText("按钮1");
		btn_2 = new MyJButton();
		btn_2.setText("按钮2");
		btn_3 = new MyJButton();
		btn_3.setText("按钮3");
		btn_4 = new MyJButton();
		btn_4.setText("按钮4");
		btn_5 = new MyJButton();
		btn_5.setText("按钮5");
		btn.setBounds(30, 50, 128, 49);
		btn_2.setBounds(200, 50, 128, 49);
		btn_3.setBounds(30, 120, 128, 49);
		btn_4.setBounds(200, 120, 128, 49);
		btn_5.setBounds(30, 200, 128, 49);
		getContentPane().add(btn);
		getContentPane().add(btn_2);
		getContentPane().add(btn_3);
		getContentPane().add(btn_4);
		getContentPane().add(btn_5);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		new Testbutton();
	}
}

