package cn.lin.chessboard;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;

import cn.lin.GUI.AboutJDialog;
import cn.lin.GUI.UIManager;
import cn.lin.action.GameAction;
import cn.lin.chess.Chess;
import cn.lin.gameboard.GameFrame;
import cn.lin.images.getImg;
import cn.lin.music.Music;
import cn.lin.testing.Testing;




public class ChessBoard extends JPanel implements ActionListener,MouseListener, MouseMotionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2660149949266527573L;
	public static ChessBoard board = new ChessBoard();
	public static final int CHESSBOARD_WIDTH = 938;// 棋盘宽度
	public static final int CHESSBOARD_HEIGHT = 580;// 棋盘高度
	public static final int CHESSBOARD_BORDER = 26;// 棋盘边长
	public static final int CHESSBOARD_LEFT = 240;// 棋盘左边预留位置
	public static final int CHESSBOARD_RIGHT = 230;// 棋盘右边预留位置
	public static final int CHESSBOARD_TOP = 80;// 棋盘上边预留位置
	public static final int CHESSBOARD_BOTTOM = 32;// 棋盘下边预留位置
	public static final int CHESSBROAD_GRID_SIZE = 26;
	public static final File backimgpath = null;
	public static final File boardimgpath = null;
	public static int[][] chesses = new int[19][19];
	public static Point position = null;
	public static boolean musicflag=true;
	
	public static final int LOCATION_X = 200;// 游戏界面载入位置
	public static final int LOCATION_Y = 50;

	public static final int PANEL_SIZE_X = 190;
	public static final int PANEL_SIZE_Y = 600;

	public static final int PALYER_PHOTO_SIZE_X = 120;// 黑棋玩家面板
	public static final int PALYER_PHOTO_SIZE_Y = 194;

	public static final int PLAYERINFO_LOCATION_X = 20;// 游戏玩家面板载入位置
	public static final int PLAYERINFO_LOCATION_Y = 50;

	public static final int PLAYERINFO_SIZE_X = 180;// 游戏玩家面板大小
	public static final int PLAYERINFO_SIZE_Y = 227;

	public static final Font font = new Font("章草", Font.BOLD, 18);

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
	
	public  int x=-1,y=-1;
	public static int tempx=-1,tempy=-1;
	public static boolean chessFlush=true;

	private  ImageIcon prtscIcon;
	
	JPanel gameinfo = new JPanel();
	

	UIManager ui = new UIManager();
	
	// 右键菜单条
		private  JPopupMenu pop ;
		private  JMenuItem save ;
		private  JMenuItem read ;
		private  JMenuItem prtsc;
		private  ImageIcon saveIcon;
		private  ImageIcon readIcon;
		
		Point top;
		Point first;
		Point second;
		boolean drag=false;
		private ImageIcon whiteicon;
		private ImageIcon blackicon;
		
	public static ChessBoard getInstance() {
		return board;
	}

	private ChessBoard() {
		// TODO 自动生成的构造函数存根
		this.setPreferredSize(new Dimension(CHESSBOARD_WIDTH, CHESSBOARD_HEIGHT));
		this.setLayout(null);
		this.setOpaque(false);
		addPanel();
		addButton();
		this.add(jpleft);
		this.add(jpright);
		
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
	}
	
	//花棋盘
	@Override
	protected void paintComponent(Graphics g) {// 绘制棋盘
		// TODO 自动生成的方法存根
		super.paintComponent(g);
		
		BufferedImage bi = new BufferedImage(938, 650,
				BufferedImage.TYPE_INT_ARGB);
		Graphics g2 = bi.createGraphics();
		g2.setColor(Color.BLACK);
		
		{// 游戏背景
			BufferedImage back = null;
			try {
				back = ImageIO.read(getImg.class
						.getResource("backyinxiang.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "游戏背景图片加载失败！！！错误：0x000001",
						"错误", JOptionPane.ERROR_MESSAGE);
			}
			g2.drawImage(back, 5, 30, this);
		}

		{
			BufferedImage title = null;
			try {
				title = ImageIO.read(getImg.class.getResource("title.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "标题图片加载失败！！！错误：0x000003",
						"错误", JOptionPane.ERROR_MESSAGE);
			}
			g2.drawImage(title, 0, 0, this);
		}

		{// 棋盘背景
			BufferedImage backimg = null;
			try {
				backimg = ImageIO.read(getImg.class
						.getResource("boardback.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "棋盘背景图片加载失败！！！错误：0x000002",
						"错误", JOptionPane.ERROR_MESSAGE);
			}
			g2.drawImage(backimg, CHESSBOARD_LEFT - 10, CHESSBOARD_TOP - 10,
					this);
		}
		for (int i = 0; i < 19; i++) {
			g2.drawLine(CHESSBOARD_LEFT, CHESSBOARD_TOP + CHESSBROAD_GRID_SIZE
					* i, CHESSBOARD_WIDTH - CHESSBOARD_RIGHT, CHESSBOARD_TOP
					+ CHESSBROAD_GRID_SIZE * i);
			g2.drawLine(CHESSBOARD_LEFT + CHESSBROAD_GRID_SIZE * i,
					CHESSBOARD_TOP, CHESSBOARD_LEFT + CHESSBROAD_GRID_SIZE * i,
					CHESSBOARD_HEIGHT - CHESSBOARD_BOTTOM);
		}

		{// 五个定点
			g2.fillOval(CHESSBOARD_LEFT + CHESSBROAD_GRID_SIZE * 9 - 5,
					CHESSBOARD_TOP + CHESSBROAD_GRID_SIZE * 9 - 5, 10, 10);
			g2.fillOval(CHESSBOARD_LEFT + CHESSBROAD_GRID_SIZE * 3 - 4,
					CHESSBOARD_TOP + CHESSBROAD_GRID_SIZE * 3 - 4, 8, 8);
			g2.fillOval(CHESSBOARD_LEFT + CHESSBROAD_GRID_SIZE * 3 - 4,
					CHESSBOARD_TOP + CHESSBROAD_GRID_SIZE * 15 - 4, 8, 8);
			g2.fillOval(CHESSBOARD_LEFT + CHESSBROAD_GRID_SIZE * 15 - 4,
					CHESSBOARD_TOP + CHESSBROAD_GRID_SIZE * 3 - 4, 8, 8);
			g2.fillOval(CHESSBOARD_LEFT + CHESSBROAD_GRID_SIZE * 15 - 4,
					CHESSBOARD_TOP + CHESSBROAD_GRID_SIZE * 15 - 4, 8, 8);
		}
		{// 棋盘边框
			// 顶部边框
			g2.drawLine(CHESSBOARD_LEFT - 11, CHESSBOARD_TOP - 11,
					CHESSBOARD_WIDTH - CHESSBOARD_RIGHT + 10,
					CHESSBOARD_TOP - 11);
			g2.drawLine(CHESSBOARD_LEFT - 10, CHESSBOARD_TOP - 10,
					CHESSBOARD_WIDTH - CHESSBOARD_RIGHT + 11,
					CHESSBOARD_TOP - 10);
			// 底部边框
			g2.drawLine(CHESSBOARD_LEFT - 11, CHESSBOARD_HEIGHT
					- CHESSBOARD_BOTTOM + 11, CHESSBOARD_WIDTH
					- CHESSBOARD_RIGHT + 10, CHESSBOARD_HEIGHT
					- CHESSBOARD_BOTTOM + 11);
			g2.drawLine(CHESSBOARD_LEFT - 10, CHESSBOARD_HEIGHT
					- CHESSBOARD_BOTTOM + 12, CHESSBOARD_WIDTH
					- CHESSBOARD_RIGHT + 11, CHESSBOARD_HEIGHT
					- CHESSBOARD_BOTTOM + 12);

			g2.drawLine(CHESSBOARD_LEFT - 11, CHESSBOARD_TOP - 11,
					CHESSBOARD_LEFT - 11, CHESSBOARD_HEIGHT - CHESSBOARD_BOTTOM
							+ 11);
			g2.drawLine(CHESSBOARD_LEFT - 10, CHESSBOARD_TOP - 10,
					CHESSBOARD_LEFT - 10, CHESSBOARD_HEIGHT - CHESSBOARD_BOTTOM
							+ 12);
			// 右边框
			g2.drawLine(CHESSBOARD_WIDTH - CHESSBOARD_RIGHT + 10,
					CHESSBOARD_TOP - 11, CHESSBOARD_WIDTH - CHESSBOARD_RIGHT
							+ 10, CHESSBOARD_HEIGHT - CHESSBOARD_BOTTOM + 11);
			g2.drawLine(CHESSBOARD_WIDTH - CHESSBOARD_RIGHT + 11,
					CHESSBOARD_TOP - 10, CHESSBOARD_WIDTH - CHESSBOARD_RIGHT
							+ 11, CHESSBOARD_HEIGHT - CHESSBOARD_BOTTOM + 12);
		}
		
		
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (GameAction.ChessBox[i][j] == 1)
					g2.drawImage(Chess.getInstance().getChess(GameAction.B),
							CHESSBOARD_LEFT + i * CHESSBROAD_GRID_SIZE - CHESSBROAD_GRID_SIZE / 2, CHESSBOARD_TOP + j * CHESSBROAD_GRID_SIZE - CHESSBROAD_GRID_SIZE
									/ 2, CHESSBROAD_GRID_SIZE, CHESSBROAD_GRID_SIZE, this);
				if (GameAction.ChessBox[i][j] == 2)
					g2.drawImage(Chess.getInstance().getChess(GameAction.W),
							CHESSBOARD_LEFT + i * CHESSBROAD_GRID_SIZE - CHESSBROAD_GRID_SIZE / 2, CHESSBOARD_TOP + j * CHESSBROAD_GRID_SIZE - CHESSBROAD_GRID_SIZE
									/ 2, CHESSBROAD_GRID_SIZE, CHESSBROAD_GRID_SIZE, this);
			}
		}
		
		if (GameAction.GameStar) {
			if (chessFlush) {
				if (tempx != -1 && tempy != -1) {
					if (Chess.getInstance().setPoint(
							new Point(
									CHESSBOARD_LEFT + tempx * CHESSBROAD_GRID_SIZE - CHESSBROAD_GRID_SIZE / 2,
									CHESSBOARD_TOP + tempy * CHESSBROAD_GRID_SIZE - CHESSBROAD_GRID_SIZE / 2))) {
						GameAction.ChessBox[tempx][tempy] = Chess
								.getInstance().getColor(GameAction.who());
						GameAction.makeChess(g);
						//ChessBoard.chessFlush=true;
						//GameAction.ChessMusic();
					}
				}
			}
		}
		
		g.drawImage(bi, 0, 0, this);
	
	}

	// 右键菜单
	public  JPopupMenu getPopupMenu() {
	
		saveIcon = new ImageIcon(getImg.class.getResource("popupmenu/saveIcon.png"));	
		readIcon = new ImageIcon(getImg.class.getResource("popupmenu/readIcon.png"));	
		prtscIcon = new ImageIcon(getImg.class.getResource("popupmenu/prtscIcon.png"));
		
		pop = new JPopupMenu();
		save = new JMenuItem("保存",saveIcon);
		read = new JMenuItem("读取",readIcon);
		prtsc = new JMenuItem("截图",prtscIcon);
		prtsc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PRINTSCREEN,InputEvent.ALT_MASK));
		pop.add(save);
		pop.add(read);
		pop.add(prtsc);


		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 保存
				if (e.getSource() == save)
					try {
						GameAction.saveAction();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				// 读取
				if (e.getSource() == read)
					try {
						GameAction.readAction();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

				//截图
				if(e.getSource() == prtsc){
					Robot robot = null;
					Point location = new Point(getLocation());
					Dimension size  = new Dimension(getSize());
					Rectangle rec = new Rectangle(location, size);
					try {
						robot = new Robot();
					} catch (AWTException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					BufferedImage screen = robot.createScreenCapture(rec);
					
					File filepath = new File("./images");
					filepath.mkdirs();
					
					JFileChooser jfc = new JFileChooser(filepath);
					jfc.setDialogTitle("保存截图：");
					jfc.setFileHidingEnabled(false);
					jfc.setFileFilter(new FileFilter() {
						
						@Override
						public String getDescription() {
							// TODO 自动生成的方法存根
							return ".jpg";
						}
						
						@Override
						public boolean accept(File f) {
							// TODO 自动生成的方法存根
							if(f.isDirectory()){
								return true;
							}
							return f.getName().endsWith(".jpg");
						}
					});
					jfc.showSaveDialog(null);
					File prtpath =jfc.getSelectedFile();
					File prtsc = new File(prtpath, jfc.getName());
					try {
						ImageIO.write(screen, "jpg", prtsc);
					} catch (IOException e2) {
						// TODO 自动生成的 catch 块
						e2.printStackTrace();
						JOptionPane.showInternalConfirmDialog(null, "截图保存失败！请重试...","提示：",JOptionPane.ERROR_MESSAGE,JOptionPane.OK_OPTION,null);
					}
					
				}

			}
		};

		//if (isAddListener) {// 防止多次添加监听器，监听器只能添加一次
			save.addActionListener(action);
			read.addActionListener(action);
			prtsc.addActionListener(action);
			//isAddListener = false;
		//}
		return pop;
	}

	public void addPanel() {
		// TODO 自动生成的方法存根
		// 左面板
		jpleft = new JPanel();
		jpleft.setSize(new Dimension(PANEL_SIZE_X, PANEL_SIZE_Y));// 左边面板的大小
		jpleft.setLayout(null);
		black.setBorder(borderblack);// 设置黑手玩家的面板边框
		borderblack.setTitleFont(font);// 设置黑手玩家的面板字体
		white.setBorder(borderwhite);
		borderwhite.setTitleFont(font);
		black.setSize(PANEL_SIZE_X, PANEL_SIZE_Y);
		white.setSize(PANEL_SIZE_X, PANEL_SIZE_Y);
		try {
			blackicon = new ImageIcon(ImageIO.read(getImg.class
					.getResource("player/black.jpg")));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			JOptionPane.showMessageDialog(this, "黑方玩家图片加载失败！！！错误：0x000003",
					"错误", JOptionPane.ERROR_MESSAGE);
		}
		try {
			whiteicon = new ImageIcon(ImageIO.read(getImg.class
					.getResource("player/white.jpg")));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			JOptionPane.showMessageDialog(this, "白方玩家图片加载失败！！！错误：0x000003",
					"错误", JOptionPane.ERROR_MESSAGE);
		}

		JLabel jlblack = new JLabel(blackicon);// 黑方游戏玩家信息面板
		jlblack.setSize(PALYER_PHOTO_SIZE_X, PALYER_PHOTO_SIZE_Y);
		JLabel jlwhite = new JLabel(whiteicon);// 白方游戏玩家信息面板
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
		
//		-------------

		// ui.min.setVisible(false);
		// ui.exit.setVisible(false);

		ui.start.addActionListener(this);
		ui.huiqi.addActionListener(this);
		ui.exit.addActionListener(this);
		ui.min.addActionListener(this);
		ui.mode.addActionListener(this);
		ui.background.addActionListener(this);
//		ui.message.addActionListener(this);
		ui.music.addActionListener(this);
		ui.version.addActionListener(this);
		
		jpright.setLayout(null);
	}

	
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(drag){
			second=e.getLocationOnScreen();
			GameFrame.getInstance().setLocation(top.x+(second.x-first.x), top.y+(second.y-first.y));
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		// 右键菜单
				int type = e.getModifiers();
				if ((type & InputEvent.BUTTON3_MASK) != 0) { // 监听右键
					JPopupMenu pop = getPopupMenu();
					pop.show(this, x, y);
				}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		x = e.getX();
		y = e.getY();
		if ((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0) { // ֻ������
			if (x >= CHESSBOARD_LEFT && y >= CHESSBOARD_TOP && x < +CHESSBOARD_LEFT + 18 * CHESSBROAD_GRID_SIZE
					&& y <= CHESSBOARD_TOP + 18 * CHESSBROAD_GRID_SIZE) {
				if (GameAction.GameStar) {
					tempx = (x - CHESSBOARD_LEFT + CHESSBROAD_GRID_SIZE / 2) / CHESSBROAD_GRID_SIZE;
					tempy = (y - CHESSBOARD_TOP + CHESSBROAD_GRID_SIZE / 2) / CHESSBROAD_GRID_SIZE;
					if (GameAction.ChessBox[tempx][tempy] == 0) {
						repaint();
						System.out.println("坐标："+tempx+" "+tempy);
						chessFlush=true;
					}
				} else {
					repaint();
				}
			}
		}
		
		if(e.getX()<=900&&e.getY()<=30){
			top=this.getLocationOnScreen();
			first=e.getLocationOnScreen();
			drag=true;
			System.out.println("OK");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		drag=false;
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource() == ui.start){
			GameAction.starAction();
		}
		
		if (e.getSource() == ui.huiqi) {
			GameAction.reMakeAction();
		}
		
		if (e.getSource() == ui.exit) {
			try {
				javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			}
			int i =JOptionPane.showConfirmDialog(null, "需要最小化到后台吗？","提示:",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null);
			if(i == 0 ){
				GameFrame.getInstance().setVisible(false);
				Testing.music.endBGMusic();
			}else {
				System.exit(0);
			}
		}
		if(e.getSource() == ui.min){
			GameFrame.getInstance().setExtendedState(GameFrame.getInstance().ICONIFIED);
		}
		
		if (e.getSource() == ui.background) {
			JOptionPane.showMessageDialog(null, "背景图片切换功能还未实现，请等待更新...");
		}
		
		if (e.getSource() == ui.message) {
			JOptionPane.showMessageDialog(null, "聊天功能还未实现，请等待更新...");
		}
		
		if (e.getSource() == ui.mode) {
			JOptionPane.showMessageDialog(null, "游戏模式功能还未实现，请等待更新...");
		}
		
		if(e.getSource() == ui.music){
			if(musicflag){
				Music.getMusic().endBGMusic();
				musicflag=!musicflag;
			} else {
				try {
					Music.getMusic().starBGMusic();
				} catch (UnsupportedAudioFileException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
				musicflag=!musicflag;
			}
		}
		if(e.getSource() == ui.version){
//			AboutJDialog.getInstance();
			AboutJDialog a = AboutJDialog.getInstance();
			a.setModal(true);
		}
	}


}
