package cn.lin.gameboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.TitledBorder;

import cn.lin.GUI.PopMenu;
import cn.lin.GUI.UIManager;
import cn.lin.action.GameAction;
import cn.lin.chessboard.ChessBoard;
import cn.lin.images.getImg;


public class GameFrame extends JFrame implements MouseListener,
		MouseMotionListener {

	/**
	 * @author Blue_Sky
	 */
	private static final long serialVersionUID = -6073563123337168353L;

	public static GameFrame gameframe=new GameFrame();
	ChessBoard board = ChessBoard.getBoard();
	UIManager ui = new UIManager();
	public int tempx;
	public int tempy;
	
	public int moveX;
	public int moveY;
	public int startX;
	public int startY;
	public static final int LOCATION_X = 200;// 游戏界面载入位置
	public static final int LOCATION_Y = 50;

	public static final int PANEL_SIZE_X = 190;
	public static final int PANEL_SIZE_Y = 600;

	public static final int PALYER_PHOTO_SIZE_X = 120;// 黑棋玩家面板
	public static final int PALYER_PHOTO_SIZE_Y = 194;

	public static final int PLAYERINFO_LOCATION_X = 30;// 游戏玩家面板载入位置
	public static final int PLAYERINFO_LOCATION_Y = 50;

	public static final int PLAYERINFO_SIZE_X = 180;// 游戏玩家面板大小
	public static final int PLAYERINFO_SIZE_Y = 227;

	public static final Font font = new Font("迷你简黄草", Font.BOLD, 18);

	public JPanel jpright;
	public JPanel jpleft;

	public TitledBorder borderblack = BorderFactory.createTitledBorder("黑方 "
			+ "玩家信息");// 带标题的面板边框
	public TitledBorder borderwhite = BorderFactory.createTitledBorder("白方"
			+ "玩家信息");

	public String mode = "";
	public TitledBorder bordergameinfo = BorderFactory
			.createTitledBorder("游戏信息");
	JPanel black = new JPanel();// 黑棋玩家面板
	JPanel white = new JPanel();// 白棋玩家面板
	JPanel gameinfo = new JPanel();

	private ImageIcon bgicon;

	public GameFrame() {
		// TODO 自动生成的构造函数存根
	}

	//单例
	public static GameFrame getInstance(){
		return gameframe;
	}
	
	public void getGameFrame_UI() {
		// TODO 自动生成的方法存根
		this.setLocation(LOCATION_X, LOCATION_Y);
		this.setTitle("五子棋         Build20140428");
		this.setUndecorated(true);// 卸载窗体装饰
		this.setBackground(new Color(0, 0, 0, 0));// 窗体透明

		this.addPanel();// 添加游戏玩家面板 和 按钮信息面板等
		this.addButton();// 添加按钮到面板上
		this.add(board);// 框架上添加棋盘

		this.pack();// 自动调整窗口
		this.setVisible(true);// 窗口可见性

		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	public void addPanel() {
		// TODO 自动生成的方法存根
		// 左面板
		jpleft = new JPanel();
		jpleft.setSize(new Dimension(PANEL_SIZE_X, PANEL_SIZE_Y));// 左边面板的大小
		jpleft.setLayout(null);
		borderblack.setTitleFont(font);// 设置黑手玩家的面板字体
		borderwhite.setTitleFont(font);
		black.setBorder(borderblack);// 设置黑手玩家的面板边框
		white.setBorder(borderwhite);
		black.setSize(PANEL_SIZE_X, PANEL_SIZE_Y);
		white.setSize(PANEL_SIZE_X, PANEL_SIZE_Y);
		try {
			bgicon = new ImageIcon(ImageIO.read(getImg.class
					.getResource("player/black.jpg")));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			JOptionPane.showMessageDialog(this, "黑方玩家图片加载失败！！！错误：0x000003",
					"错误", JOptionPane.ERROR_MESSAGE);
		}
		try {
			bgicon = new ImageIcon(ImageIO.read(getImg.class
					.getResource("player/white.jpg")));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			JOptionPane.showMessageDialog(this, "白方玩家图片加载失败！！！错误：0x000003",
					"错误", JOptionPane.ERROR_MESSAGE);
		}

		JLabel jlblack = new JLabel(bgicon);// 黑方游戏玩家信息面板
		jlblack.setSize(PALYER_PHOTO_SIZE_X, PALYER_PHOTO_SIZE_Y);
		JLabel jlwhite = new JLabel(bgicon);// 白方游戏玩家信息面板
		jlwhite.setSize(PALYER_PHOTO_SIZE_X, PALYER_PHOTO_SIZE_Y);

		black.add(jlblack);
		white.add(jlwhite);
		jpleft.add(black);// 黑方游戏玩家信息面板
		jpleft.add(white);
		black.setBackground(new Color(0, 0, 0, 0));
		white.setBackground(new Color(0, 0, 0, 0));
		black.setBounds(PLAYERINFO_LOCATION_X, PLAYERINFO_LOCATION_Y,
				PLAYERINFO_SIZE_X, PLAYERINFO_SIZE_Y);
		white.setBounds(PLAYERINFO_LOCATION_X, PLAYERINFO_LOCATION_Y
				+ PLAYERINFO_SIZE_Y + 50, PLAYERINFO_SIZE_X, PLAYERINFO_SIZE_Y);

		jpleft.setOpaque(false);// 游戏信息面板设置透明

		// 右面板
		jpright = new JPanel();
		jpright.setSize(new Dimension(ChessBoard.CHESSBOARD_LEFT - 10, 600));// 右边面板的大小
		jpright.setLocation(714, 50);// 右边面板的载入位置
		jpright.setOpaque(false);// 透明度

		bordergameinfo.setTitleFont(font);
		gameinfo.setBorder(bordergameinfo);
		gameinfo.setOpaque(false);
		gameinfo.setBounds(10, 30, 200, 140);
		jpright.add(gameinfo);

		board.add(jpleft);
		board.add(jpright);
	}

	public void addButton() {
		// TODO 自动生成的方法存根

		jpright.add(ui.start);
		jpright.add(ui.huiqi);
		jpright.add(ui.mode);
		jpright.add(ui.music);
		jpright.add(ui.background);
		jpright.add(ui.version);
		add(ui.min);
		add(ui.exit);

		// ui.min.setVisible(false);
		// ui.exit.setVisible(false);
		ui.min.addMouseListener(this);
		ui.exit.addMouseListener(this);

		jpright.setLayout(null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
			JPopupMenu pop = PopMenu.getPopMenu();
			pop.show(this, e.getX(), e.getY());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		System.out.println(e.getX() + "     y = " + e.getY());
		if (e.getY() >= 0 && e.getY() <= 30) {// 移动窗口
			moveX = this.getLocationOnScreen().x;
			moveY = this.getLocationOnScreen().y;

			startX = e.getLocationOnScreen().x;
			startY = e.getLocationOnScreen().y;

		}
		if (e.getX() <= ChessBoard.CHESSBOARD_WIDTH && e.getX() >= 0) {

		}

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
//		Player p = WinAction().win(p, tempx	, tempy);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		/*
		 * if (e.getX() >= 860 && e.getX() <= 885 && e.getY() >= 22 && e.getY()
		 * <= 48) { ui.min.setVisible(true); System.out.println("e=" + e.getX()
		 * + "     y =" + e.getY()); }
		 * 
		 * if (e.getX() >= 890 && e.getX() <= 915 && e.getY() >= 22 && e.getY()
		 * <=48) { ui.exit.setVisible(true); }
		 */
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		/*
		 * if (e.getX() >= 860 && e.getX() <= 885 && e.getY() >= 22 && e.getY()
		 * <= 48) { ui.min.setVisible(false); System.out.println("e=" + e.getX()
		 * + "     y =" + e.getY()); }
		 * 
		 * if (e.getX() >= 890 && e.getX() <= 915 && e.getY() >= 22 && e.getY()
		 * <= 48) { ui.exit.setVisible(false); }
		 */
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自动生成的方法存根
		if (e.getY() >= 0 && e.getY() <= 30) {// 移动窗口
			int newX = (e.getLocationOnScreen().x - startX) + moveX;
			int newY = (e.getLocationOnScreen().y - startY) + moveY;
			this.setLocation(newX, newY);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自动生成的方法存根

	}
}
