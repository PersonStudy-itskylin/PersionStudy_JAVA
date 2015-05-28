package cn.lin.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import cn.lin.Button.GameMainJButton;
import cn.lin.DBDao.DBqueryAll;
import cn.lin.audio.getAudio;
import cn.lin.gameboard.GameFrame;
import cn.lin.images.getImg;
import cn.lin.testing.Testing;

public class Login extends JFrame implements ActionListener {
	/**
	 * @author Blue_Sky
	 */
	private static final long serialVersionUID = -1783041396023825785L;
	private static final int FRAME_SIZE_X = 450;
	private static final int FRAME_SIZE_Y = 380;
	private static final int JL_LOCATION_X = 100;
	private static final int JL_LOCATION_Y = 100;
	private static final int JL_SIZE_X = 70;
	private static final int JL_SIZE_Y = 40;
	private static final int JT_SIZE_X = 110;
	private static final int JT_SIZE_Y = 20;
	private static final int JB_SIZE = 80;
	private static Login login = new Login();
	private JLabel jluser;
	private JLabel jlpwd;
	private JTextField jtuser;
	private JPasswordField jtpwd;
	private JButton jblogin;
	private GameMainJButton jbexit;
	DBqueryAll quer = new DBqueryAll();
	static JPanel jplogin;
	
	public static Login Login() {
		// TODO 自动生成的构造函数存根
		return login;
	}
	
	public JPanel addPanel() {
		jplogin = new Logingback();
		jplogin.setSize(new Dimension(FRAME_SIZE_X, FRAME_SIZE_Y));
		jplogin.setLayout(null);
		jluser = new JLabel("账号：");
		jluser.setForeground(Color.WHITE);
		jlpwd = new JLabel("密码：");
		jlpwd.setForeground(Color.WHITE);
		jtuser = new JTextField();
		jtpwd = new JPasswordField();

		jluser.setFont(GameFrame.font);
		jlpwd.setFont(GameFrame.font);
		jluser.setBounds(JL_LOCATION_X, JL_LOCATION_Y, JL_SIZE_X, JL_SIZE_Y);
		jlpwd.setBounds(JL_LOCATION_X, JL_LOCATION_Y + JL_SIZE_Y, JL_SIZE_X,
				JL_SIZE_Y);
		jtuser.setBounds(JL_LOCATION_X + JL_SIZE_X - 20, JL_LOCATION_Y
				+ JL_SIZE_Y / 3, JT_SIZE_X, JT_SIZE_Y);
		jtpwd.setBounds(JL_LOCATION_X + JL_SIZE_X - 20, JL_LOCATION_Y
				+ JL_SIZE_Y + JL_SIZE_Y / 3, JT_SIZE_X, JT_SIZE_Y);
		
		jtpwd.setEchoChar('*');

		try {
			jblogin = new GameMainJButton();
			jbexit = new GameMainJButton();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		jblogin.setText("登录");
		jbexit.setText("退出");

		jblogin.setBounds(JL_LOCATION_X + JL_LOCATION_X / 4, JL_LOCATION_Y
				+ JL_SIZE_Y * 2, JB_SIZE, JB_SIZE);
		jbexit.setBounds(JL_LOCATION_X + JL_LOCATION_X, JL_LOCATION_Y
				+ JL_SIZE_Y * 2, JB_SIZE, JB_SIZE);

		jplogin.add(jluser);
		jplogin.add(jtuser);
		jplogin.add(jlpwd);
		jplogin.add(jtpwd);
		jplogin.add(jblogin);
		jplogin.add(jbexit);

		// jplogin.setBackground(new Color(153,0,0,0));
//		jplogin.setOpaque(false);
		return jplogin;
	}

	public void getLogin_UI() {
		this.setTitle("五子棋-用户登录");
		this.setSize(500, 400);

		this.add(addPanel());
		this.setUndecorated(true);
		this.setBackground(new Color(0, 0, 0, 0));
//		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		jbexit.addActionListener(this);
		jblogin.addActionListener(this);
	}

	public static void main(String[] args) {
		login.getLogin_UI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (e.getSource() == jbexit) {
			int result = JOptionPane.showConfirmDialog(this, "确定要退出吗？", "退出提示",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					null);
			if (result == 0) {
				System.exit(0);
			}
		}
		if(e.getSource() == jblogin){
			DBqueryAll db = new DBqueryAll();
			ResultSet rs = db.queryAll("USERS");
			String user = jtuser.getText();
			String pwd = jtpwd.getText();
			boolean flag = false;
			try {
				while(rs.next()){
					String DBuser = rs.getString(2);
					String DBpwd = rs.getString(3);
					if(user.equals(DBuser) && pwd.equals(DBpwd)){
						JOptionPane.showMessageDialog(null, "登陆成功！！！");
						flag = true;
						break;
					}else {
						JOptionPane.showMessageDialog(null, "账号或密码错误！！！");
						break;
					}
				}
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			if(flag){
				new Testing();
			}
		}
	}

}

class Logingback extends JPanel{

	/**
	 * @author Blue_Sky
	 */
	private static final long serialVersionUID = -171757301578967289L;
	public Logingback() {
		// TODO 自动生成的构造函数存根
		this.setOpaque(false);
		this.setBackground(new Color(0,0,0,0));
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO 自动生成的方法存根{// 棋盘背景
		BufferedImage backimg = null;
		try {
			backimg = ImageIO.read(getImg.class.getResource("back.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "登陆背景图片加载失败！！！错误：0x000005",
					"错误", JOptionPane.ERROR_MESSAGE);
		}
		g.drawImage(backimg, 0, 0, this);
		repaint();
	}
}
