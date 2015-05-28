package fcg;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class other {

}

// 初始化黑方
class setB extends JFrame implements ActionListener {
	public JLabel jl1, jl2;
	public JTextField jt1;
	public JPanel jp, jp1, jp2, jp3;
	public JButton jb1, jb2;

	public setB() {
		// TODO Auto-generated constructor stub

		setTitle("黑方注册");
		setSize(250, 200);
		setLocation(450, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

		jl1 = new JLabel("阁下大名：");
		jt1 = new JTextField(8);
		jb1 = new JButton("确定");
		jb2 = new JButton("重置");
		jp = new JPanel();
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		add(jp);
		jp.setLayout(new GridLayout(3, 2));
		jp.add(jp1);
		jp.add(jp2);
		jp2.add(jl1);
		jp2.add(jt1);
		jp.add(jp3);
		jp3.add(jb1);
		jp3.add(jb2);

		jb1.addActionListener(this);
		jb2.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jb2) {
			jt1.setText("");
		}
		if (e.getSource() == jb1) {
			System.out.println("");
			if (jt1.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "请输入信息");
			} else {
				if (jt1.getText().length() < 5) {
					GameAction.B.setName(jt1.getText());
					this.setVisible(false);
					GameAction.B.setPlay(true);
					ChessFrame.getInstance().repaint();
					new setW();
				} else {
					JOptionPane.showMessageDialog(this, "请小于5个字");
				}
			}
		}
	}
}

// 初始化 白方
class setW extends JFrame implements ActionListener {
	public JLabel jl1, jl2;
	public JTextField jt1;
	public JPanel jp, jp1, jp2, jp3;
	public JButton jb1, jb2;

	public setW() {
		// TODO Auto-generated constructor stub

		setTitle("白方注册");
		setSize(250, 200);
		setLocation(750, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

		jl1 = new JLabel("阁下大名：");
		jt1 = new JTextField(8);
		jb1 = new JButton("确定");
		jb2 = new JButton("重置");
		jp = new JPanel();
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		add(jp);
		jp.setLayout(new GridLayout(3, 2));
		jp.add(jp1);
		jp.add(jp2);
		jp2.add(jl1);
		jp2.add(jt1);
		jp.add(jp3);
		jp3.add(jb1);
		jp3.add(jb2);

		jb1.addActionListener(this);
		jb2.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jb2) {
			jt1.setText("");
		}
		if (e.getSource() == jb1) {
			System.out.println("");
			if (jt1.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "请输入信息");
			} else {
				if (jt1.getText().length() < 5) {
					GameAction.W.setName(jt1.getText());
					GameAction.W.setPlay(false);
					ChessFrame.getInstance().repaint();
					GameAction.GameStar = true;
					ChessFrame.chessFlush = true;
					GameAction.Playermake = true;
					setVisible(false);
					if (GameAction.TimeFlag) { // 开始黑方时间进度条
						GameAction.Btime.Start();
					}
				} else {
					JOptionPane.showMessageDialog(this, "请小于5个字");
				}
			}
		}
	}

}

// 时间进度条线程
class BTimeJProgress implements Runnable {
	static Thread timerun = new Thread(new BTimeJProgress());
	public static int timevalue = 0;
	public static boolean flag = false;

	public void Start() {
		// TODO Auto-generated method stub
		timerun.start();
	}

	public void Suspend() {
		// TODO Auto-generated method stub
		timerun.suspend();
	}

	public void current() {
		timerun.resume();
	}

	public void Stop() {
		// TODO Auto-generated method stub
		timerun.stop();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (timevalue = 0; timevalue < 101; timevalue++) {
			try {
				Thread.sleep(GameAction.Maxtime * 10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ChessFrame.Btime.setValue(timevalue);
			if (timevalue == 100) {
				if (GameAction.who() == GameAction.B)
					GameAction.end(GameAction.W);
				else
					GameAction.end(GameAction.B);
			}
		}
	}

}

// 白方时间
class WTimeJProgress implements Runnable {
	public static Thread timerun = new Thread(new WTimeJProgress());
	public static int timevalue = 0;
	public static boolean flag = false;

	public void Start() {
		// TODO Auto-generated method stub
		timerun.start();
	}

	public void Suspend() {
		// TODO Auto-generated method stub
		timerun.suspend();
	}

	public void Stop() {
		// TODO Auto-generated method stub
		timerun.stop();
	}

	public void current() {
		timerun.resume();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (timevalue = 0; timevalue < 101; timevalue++) {
			try {
				Thread.sleep(GameAction.Maxtime * 10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ChessFrame.Wtime.setValue(timevalue);
			if (timevalue == 100) {
				if (GameAction.who() == GameAction.B)
					GameAction.end(GameAction.W);
				else
					GameAction.end(GameAction.B);
			}
		}
	}

}
