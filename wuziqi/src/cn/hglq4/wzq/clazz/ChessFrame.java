package cn.hglq4.wzq.clazz;

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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;

import cn.hglq4.wzq.button.GameExit;
import cn.hglq4.wzq.button.GameMainJButton;
import cn.hglq4.wzq.button.GameMin;
import cn.hglq4.wzq.img.ImageJar;



public class ChessFrame extends JPanel implements ActionListener,
		MouseListener, MouseMotionListener {

	/**
	 * @author Blue_Sky
	 */
	private static final long serialVersionUID = -2870443053244705998L;
	private int locx = GameAction.locx;
	private int locy = GameAction.locy;
	private int size = GameAction.size;
	private Point top = null;
	private Point first = null;
	public static Point second = null;
	public static ChessFrame chessframe = new ChessFrame();
	private JPanel startjp, remakejp, soundjp, robotjp;
	private JButton start, remake, sound, robot,exit,min;
	public static JProgressBar Btime, Wtime;
	private boolean drag = false;
	public static boolean musicFlag = true;
	public static boolean chessFlush = false;
	private int x, y;
	static int tempx = -1, tempy = -1;
	
	// 右键菜单条
	private  JPopupMenu pop ;
	private  JMenuItem save ;
	private  JMenuItem read ;
	private  JMenuItem time ;
	private  JMenuItem bg ;
	private  JMenuItem prtsc;
	private  ImageIcon saveIcon;
	private  ImageIcon readIcon;
	private  ImageIcon timeIcon;
	private  ImageIcon bgIcon;
	private  ImageIcon prtscIcon;
	//private  boolean isAddListener = true;

	// 单例对象
	public static ChessFrame getInstance() {
		return chessframe;
	}

	// 私有构造方法
	private ChessFrame() {

		setLayout(null);

		Btime = new JProgressBar(0, 100);
		Btime.setBounds(locx / 2 - 60, locy + size * 2 + 260, 120, 10);
		Btime.setBackground(Color.CYAN);
		Btime.setVisible(false);

		Wtime = new JProgressBar(0, 100);
		Wtime.setBounds(880 - locx / 2 - 70, locy + size * 2 + 260, 120, 10);
		Wtime.setBackground(Color.CYAN);
		Wtime.setVisible(false);
		add(Btime);
		add(Wtime);

		try {
			start = new GameMainJButton();
			start.setText("开始");
			robot = new GameMainJButton();
			robot.setText("人机");
			remake = new GameMainJButton();
			remake.setText("悔棋");
			sound = new GameMainJButton();
			sound.setText("声音");
			exit=new GameExit();
			min =new GameMin();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 开始
		startjp = new JPanel();
		startjp.setBounds(locx, locy + size * 18 + 20, 60, 60);	
		startjp.setOpaque(false);
		add(startjp);
		startjp.add(start);

		//人机
		robotjp = new JPanel();
		robotjp.setBounds(locx + size * 3, locy + size * 18 + 20, 60, 60);
		robotjp.setOpaque(false);
		robotjp.setBackground(null);
//		robot = new JButton("人机");
		add(robotjp);
		robotjp.add(robot);

		//悔棋
		remakejp = new JPanel();
		remakejp.setBounds(locx + size * 6, locy + size * 18 + 20, 60, 60);
		remakejp.setOpaque(false);
		remakejp.setBackground(null);
//		remake = new JButton("悔棋");
		add(remakejp);
		remakejp.add(remake);

		//声音
		soundjp = new JPanel();
		soundjp.setBounds(locx + size * 9, locy + size * 18 + 20, 60, 60);
		soundjp.setOpaque(false);
		soundjp.setBackground(null);
//		sound = new JButton("声音");
		add(soundjp);
		soundjp.add(sound);

        //关闭
		exit.setBounds(GameAction.height-20, -10, 20, 40);
		exit.setVisible(false);
		add(exit);
		
		//最小化
		min.setBounds(GameAction.height-40, -10, 20, 40);
		min.setVisible(false);
		add(min);
		
		this.addMouseMotionListener(this);
		addMouseListener(this);
		start.addActionListener(this);
		remake.addActionListener(this);
		sound.addActionListener(this);
		robot.addActionListener(this);
		exit.addActionListener(this);
		min.addActionListener(this);
	}

	// 绘制ChessFrame
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		BufferedImage bi = new BufferedImage(880, 645,
				BufferedImage.TYPE_INT_ARGB);
		Graphics g2 = bi.createGraphics();
		g2.setColor(Color.BLACK);

		// 背景图片
		g2.drawImage(Image.getInstance().getbg(), 0, 0, this);

		// 黑色玩家头像
		g2.setColor(Color.WHITE);
		g2.drawImage(Image.getInstance().getBborder(), locx / 2 - 60, locy
				+ size * 2, this);
		g2.drawImage(Image.getInstance().getBT(), locx / 2 - 60 + 18, locy
				+ size * 2 + 30, this);
		g2.setFont(new Font("楷体", Font.CENTER_BASELINE, 20));
		g2.drawString(GameAction.B.getName(), locx / 2 - 60 + 18 + 4, locy
				+ size * 2 + 30 + 170);

		// 白色玩家头像
		g2.setColor(Color.BLACK);
		g2.drawImage(Image.getInstance().getWborder(), 880 - locx / 2 - 70,
				locy + size * 2, this);
		g2.drawImage(Image.getInstance().getWT(), 880 - locx / 2 - 70 + 18,
				locy + size * 2 + 30, this);
		g2.setFont(new Font("楷体", Font.CENTER_BASELINE, 20));
		g2.drawString(GameAction.W.getName(), 880 - locx / 2 - 70 + 18 + 4,
				locy + size * 2 + 30 + 170);

		// // 中间VS信息
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("楷体", Font.PLAIN, 20));
		g2.drawString("黑方：" + GameAction.B.getName(), locx + size, locy - 20);
		g2.setFont(new Font("华文隶书", Font.BOLD, 40));
		g2.drawString("V", locx + size * 9 - 25, locy - 25);
		g2.setColor(Color.WHITE);
		g2.drawString("S", locx + size * 9, locy - 15);
		g2.setFont(new Font("楷体", Font.PLAIN, 20));
		g2.drawString(GameAction.W.getName(), locx + size * 15 - 80, locy - 20);
		g2.drawString("：白方", locx + size * 15, locy - 20);
		g2.setColor(Color.BLACK);


		// 画棋盘
		for (int i = 0; i <= 18; i++) {
			g2.drawLine(locx + i * size, locy, locx + i * size, locy + 18
					* size);
			g2.drawLine(locx, locy + i * size, locx + 18 * size, locy + i
					* size);
		}

		// 画边框
		g2.drawLine(locx - 8, locy - 8, locx + size * 18 + 8, locy - 8);
		g2.drawLine(locx - 8, locy + size * 18 + 8, locx + size * 18 + 8, locy
				+ size * 18 + 8);
		g2.drawLine(locx - 8, locy - 8, locx - 8, locy + size * 18 + 8);
		g2.drawLine(locx + size * 18 + 8, locy - 8, locx + size * 18 + 8, locy
				+ size * 18 + 8);
		g2.drawLine(locx - 7, locy - 7, locx + size * 18 + 7, locy - 7);
		g2.drawLine(locx - 7, locy + size * 18 + 7, locx + size * 18 + 7, locy
				+ size * 18 + 7);
		g2.drawLine(locx - 7, locy - 7, locx - 7, locy + size * 18 + 7);
		g2.drawLine(locx + size * 18 + 7, locy - 7, locx + size * 18 + 7, locy
				+ size * 18 + 7);

		// 打印五个标志棋子
		g2.drawOval(locx + size * 3 - 3, locy + size * 3 - 3, 6, 6);
		g2.fillOval(locx + size * 3 - 3, locy + size * 3 - 3, 6, 6);
		g2.drawOval(locx + size * 9 - 3, locy + size * 9 - 3, 6, 6);
		g2.fillOval(locx + size * 9 - 3, locy + size * 9 - 3, 6, 6);
		g2.drawOval(locx + size * 3 - 3, locy + size * 15 - 3, 6, 6);
		g2.fillOval(locx + size * 3 - 3, locy + size * 15 - 3, 6, 6);
		g2.drawOval(locx + size * 15 - 3, locy + size * 3 - 3, 6, 6);
		g2.fillOval(locx + size * 15 - 3, locy + size * 3 - 3, 6, 6);
		g2.drawOval(locx + size * 15 - 3, locy + size * 15 - 3, 6, 6);
		g2.fillOval(locx + size * 15 - 3, locy + size * 15 - 3, 6, 6);

		// 棋盘保存
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (GameAction.ChessBox[i][j] == 1)
					g2.drawImage(Chess.getInstance().getChess(GameAction.B),
							locx + i * size - size / 2, locy + j * size - size
									/ 2, size, size, this);
				if (GameAction.ChessBox[i][j] == 2)
					g2.drawImage(Chess.getInstance().getChess(GameAction.W),
							locx + i * size - size / 2, locy + j * size - size
									/ 2, size, size, this);
			}
		}

		
		// 下棋子
		if (GameAction.GameStar) {
			if (chessFlush) {
				System.out.println("刷新了");
				if (tempx != -1 && tempy != -1) {
					if (Chess.getInstance().setPoint(
							new Point(
									locx + ChessFrame.tempx * size - size / 2,
									locy + ChessFrame.tempy * size - size / 2))) {// 保存棋子坐标
						GameAction.ChessBox[ChessFrame.tempx][ChessFrame.tempy] = Chess
								.getInstance().getColor(GameAction.who());
						GameAction.makeChess(g2);// 画出棋子
						GameAction.ChessMusic();// 下棋子声音
					}
				}
			}
		}

		// AI

		g.drawImage(bi, 0, 0, this);
	}

	// 右键菜单
	public  JPopupMenu getPopupMenu() {
	
		saveIcon = new ImageIcon(ImageJar.class.getResource("pop/saveIcon.png"));	
		readIcon = new ImageIcon(ImageJar.class.getResource("pop/readIcon.png"));	
		timeIcon = new ImageIcon(ImageJar.class.getResource("pop/timeIcon.png"));	
		bgIcon = new ImageIcon(ImageJar.class.getResource("pop/bgIcon.png"));	
		prtscIcon = new ImageIcon(ImageJar.class.getResource("pop/prtscIcon.png"));
		
		pop = new JPopupMenu();
		save = new JMenuItem("保存",saveIcon);
		read = new JMenuItem("读取",readIcon);
		time = new JMenuItem("时间设置",timeIcon);
		bg = new JMenuItem("更换背景",bgIcon);
		prtsc = new JMenuItem("截图",prtscIcon);
		prtsc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PRINTSCREEN,InputEvent.ALT_MASK));
		pop.add(save);
		pop.add(read);
		pop.add(prtsc);
		pop.add(time);
		pop.add(bg);

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

				// 时间
				if (e.getSource() == time){
					GameAction.timeAction();					
				}

				// 背景
				if (e.getSource() == bg){
					GameAction.bgAction();
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
			time.addActionListener(action);
			bg.addActionListener(action);
			prtsc.addActionListener(action);
			//isAddListener = false;
		//}
		return pop;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 双人
		if (e.getSource() == start){
			GameAction.startAction();	
//			new Jdialog().show();
		}

		// 人机
		if (e.getSource() == robot){
			GameAction.robotAction();	
		}

		// 悔棋
		if (e.getSource() == remake){
			GameAction.reMakeAction();
		}

		// 声音
		if (e.getSource() == sound){
			GameAction.SoundAction();			
		}
        
		//关闭
		if (e.getSource() == exit){
			System.exit(0);			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		if ((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0) { // 只监控左键
			// 更换头像
			if (x >= locx / 2 - 60 + 18 && y >= locy + size * 2 + 30
					&& x <= locx / 2 - 60 + 18 + 85
					&& y <= locy + size * 2 + 30 + 130) {
				System.out.println("黑方头像");
				GameAction.BTpicActon();
			}
			if (x >= 880 - locx / 2 - 70 + 18 && y >= locy + size * 2 + 30
					&& x <= 880 - locx / 2 - 70 + 18 + 85
					&& y <= locy + size * 2 + 30 + 130) {
				System.out.println("白方头像");
				GameAction.WTpicActon();
			}
		}

		// 右键菜单
		int type = e.getModifiers();
		if ((type & InputEvent.BUTTON3_MASK) != 0) { // 监听右键
			JPopupMenu pop = getPopupMenu();
			pop.show(this, x, y);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		if ((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0) { // 只监控左键
			if (x >= locx && y >= locy && x < +locx + 18 * size
					&& y <= locy + 18 * size) {
				if (GameAction.GameStar) {
					tempx = (x - locx + size / 2) / size;
					tempy = (y - locy + size / 2) / size;
					if (GameAction.ChessBox[tempx][tempy] == 0) { // 如果当前位置有子、则不画棋子
						chessFlush=true;
						repaint();
					}
				} else {
					repaint();
				}
			}

			// 拖拽
			if (x <= GameAction.height - 40 && y <= locy) {
				top = this.getLocationOnScreen();
				first = e.getLocationOnScreen();
				drag = true;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		drag = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//关闭  最小化按钮显示
		if(e.getX()>=GameAction.height-40&&e.getX()<=GameAction.height&&e.getY()>=0&&e.getY()<=20){
			exit.setVisible(true);
			min.setVisible(true);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (drag) {
			second = e.getLocationOnScreen();
			ChessFrame.getInstance().setLocation(second.x - first.x + top.x,
					second.y - first.y + top.y);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

}
