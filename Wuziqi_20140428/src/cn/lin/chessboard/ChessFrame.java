package cn.lin.chessboard;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;

import cn.lin.Button.GameExit;
import cn.lin.Button.GameMainJButton;
import cn.lin.Button.GameMin;
import cn.lin.action.GameAction;
import cn.lin.chess.Chess;
import cn.lin.images.getImg;





public class ChessFrame extends JPanel implements ActionListener,
		MouseListener, MouseMotionListener {
	
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
	public static int tempx = -1;
	public static int tempy = -1;
	
	// �Ҽ�˵���
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

	// �������
	public static ChessFrame getInstance() {
		return chessframe;
	}

	// ˽�й��췽��
	private ChessFrame() {

		setLayout(null);

		try {
			start = new GameMainJButton();
			start.setText("��ʼ");
			robot = new GameMainJButton();
			robot.setText("�˻�");
			remake = new GameMainJButton();
			remake.setText("����");
			sound = new GameMainJButton();
			sound.setText("����");
			exit=new GameExit();
			min =new GameMin();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ��ʼ
		startjp = new JPanel();
		startjp.setBounds(locx, locy + size * 18 + 20, 60, 60);	
		startjp.setOpaque(false);
		add(startjp);
		startjp.add(start);

		//�˻�
		robotjp = new JPanel();
		robotjp.setBounds(locx + size * 3, locy + size * 18 + 20, 60, 60);
		robotjp.setOpaque(false);
		robotjp.setBackground(null);
//		robot = new JButton("�˻�");
		add(robotjp);
		robotjp.add(robot);

		//����
		remakejp = new JPanel();
		remakejp.setBounds(locx + size * 6, locy + size * 18 + 20, 60, 60);
		remakejp.setOpaque(false);
		remakejp.setBackground(null);
//		remake = new JButton("����");
		add(remakejp);
		remakejp.add(remake);

		//����
		soundjp = new JPanel();
		soundjp.setBounds(locx + size * 9, locy + size * 18 + 20, 60, 60);
		soundjp.setOpaque(false);
		soundjp.setBackground(null);
//		sound = new JButton("����");
		add(soundjp);
		soundjp.add(sound);

        //�ر�
		exit.setBounds(GameAction.height-20, -10, 20, 40);
		exit.setVisible(false);
		add(exit);
		
		//��С��
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

	// ����ChessFrame
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		BufferedImage bi = new BufferedImage(880, 645,
				BufferedImage.TYPE_INT_ARGB);
		Graphics g2 = bi.createGraphics();
		g2.setColor(Color.BLACK);
		
		
		// ������
		for (int i = 0; i <= 18; i++) {
			g2.drawLine(locx + i * size, locy, locx + i * size, locy + 18
					* size);
			g2.drawLine(locx, locy + i * size, locx + 18 * size, locy + i
					* size);
		}

		// ���߿�
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

		// ��ӡ�����־����
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

		// ���̱���
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

		
		// ������
		if (GameAction.GameStar) {
			if (chessFlush) {
				System.out.println("ˢ����");
				if (tempx != -1 && tempy != -1) {
					if (Chess.getInstance().setPoint(
							new Point(
									locx + ChessFrame.tempx * size - size / 2,
									locy + ChessFrame.tempy * size - size / 2))) {// �����������
						GameAction.ChessBox[ChessFrame.tempx][ChessFrame.tempy] = Chess
								.getInstance().getColor(GameAction.who());
						GameAction.makeChess(g2);// ��������
						GameAction.ChessMusic();// ����������
				
					}
				}
			}
		}

		// AI

		g.drawImage(bi, 0, 0, this);
	}

	// �Ҽ�˵�
	public  JPopupMenu getPopupMenu() {
	
		saveIcon = new ImageIcon(getImg.class.getResource("pop/saveIcon.png"));	
		readIcon = new ImageIcon(getImg.class.getResource("pop/readIcon.png"));	
		timeIcon = new ImageIcon(getImg.class.getResource("pop/timeIcon.png"));	
		bgIcon = new ImageIcon(getImg.class.getResource("pop/bgIcon.png"));	
		prtscIcon = new ImageIcon(getImg.class.getResource("pop/prtscIcon.png"));
		
		pop = new JPopupMenu();
		save = new JMenuItem("����",saveIcon);
		read = new JMenuItem("��ȡ",readIcon);
		time = new JMenuItem("ʱ������",timeIcon);
		bg = new JMenuItem("���",bgIcon);
		prtsc = new JMenuItem("��ͼ",prtscIcon);
		prtsc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PRINTSCREEN,InputEvent.ALT_MASK));
		pop.add(save);
		pop.add(read);
		pop.add(prtsc);
		pop.add(time);
		pop.add(bg);

		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����
				if (e.getSource() == save)
					try {
						GameAction.saveAction();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				// ��ȡ
				if (e.getSource() == read)
					try {
						GameAction.readAction();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

				// ʱ��
				if (e.getSource() == time){
					GameAction.timeAction();					
				}

				
				//��ͼ
				if(e.getSource() == prtsc){
					Robot robot = null;
					Point location = new Point(getLocation());
					Dimension size  = new Dimension(getSize());
					Rectangle rec = new Rectangle(location, size);
					try {
						robot = new Robot();
					} catch (AWTException e1) {
						// TODO �Զ���ɵ� catch ��
						e1.printStackTrace();
					}
					BufferedImage screen = robot.createScreenCapture(rec);
					
					File filepath = new File("./images");
					filepath.mkdirs();
					
					JFileChooser jfc = new JFileChooser(filepath);
					jfc.setDialogTitle("�����ͼ��");
					jfc.setFileHidingEnabled(false);
					jfc.setFileFilter(new FileFilter() {
						
						@Override
						public String getDescription() {
							// TODO �Զ���ɵķ������
							return ".jpg";
						}
						
						@Override
						public boolean accept(File f) {
							// TODO �Զ���ɵķ������
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
						// TODO �Զ���ɵ� catch ��
						e2.printStackTrace();
						JOptionPane.showInternalConfirmDialog(null, "��ͼ����ʧ�ܣ�������...","��ʾ��",JOptionPane.ERROR_MESSAGE,JOptionPane.OK_OPTION,null);
					}
					
				}

			}
		};

		//if (isAddListener) {// ��ֹ�����Ӽ�������������ֻ�����һ��
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
		// ˫��
		if (e.getSource() == start)
			GameAction.startAction();

		// �˻�
		if (e.getSource() == robot)
			GameAction.robotAction();

		// ����
		if (e.getSource() == remake)
			GameAction.reMakeAction();

		// ����
		if (e.getSource() == sound)
			GameAction.SoundAction();
        
		//�ر�
		if (e.getSource() == exit)
			System.exit(0);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();

		// �Ҽ�˵�
		int type = e.getModifiers();
		if ((type & InputEvent.BUTTON3_MASK) != 0) { // �����Ҽ�
			JPopupMenu pop = getPopupMenu();
			pop.show(this, x, y);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		if ((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0) { // ֻ������
			if (x >= locx && y >= locy && x < +locx + 18 * size
					&& y <= locy + 18 * size) {
				if (GameAction.GameStar) {
					
					tempx = (x - locx + size / 2) / size;
					tempy = (y - locy + size / 2) / size;
					if (GameAction.ChessBox[tempx][tempy] == 0) { // ���ǰλ�����ӡ��򲻻�����
						chessFlush=true;
						repaint();
					}
				} else {
					repaint();
				}
			}

			// ��ק
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
		//�ر�  ��С����ť��ʾ
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
