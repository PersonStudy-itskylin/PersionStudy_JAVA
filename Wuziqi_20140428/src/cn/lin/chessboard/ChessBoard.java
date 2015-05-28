package cn.lin.chessboard;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cn.lin.action.GameAction;
import cn.lin.chess.Chess;
import cn.lin.gameboard.GameFrame;
import cn.lin.images.getImg;



public class ChessBoard extends JPanel implements MouseMotionListener,MouseListener{

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
	
	//更改
	private Point top = null;
	private Point first = null;
	public static Point second = null;
	private boolean drag = false;
	
	public static boolean chessFlush=false;
	public static int tempx=-1,tempy=-1;
	private int x,y;
	

	public static ChessBoard getBoard() {
		return board;
	}

	private ChessBoard() {
		// TODO 自动生成的构造函数存根
		this.setPreferredSize(new Dimension(CHESSBOARD_WIDTH, CHESSBOARD_HEIGHT));
		this.setLayout(null);
		this.setOpaque(false);
		
		//GameFrame.getInstance().addPanel();// 添加游戏玩家面板 和 按钮信息面板等
		//GameFrame.getInstance().addButton();// 添加按钮到面板上
		this.addMouseMotionListener(this);
		addMouseListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {// 绘制棋盘
		// TODO 自动生成的方法存根
		super.paintComponent(g);
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
			g.drawImage(back, 5, 30, this);
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
			g.drawImage(title, 0, 0, this);
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
			g.drawImage(backimg, CHESSBOARD_LEFT - 10, CHESSBOARD_TOP - 10,
					this);
		}
		for (int i = 0; i < 19; i++) {
			g.drawLine(CHESSBOARD_LEFT, CHESSBOARD_TOP + CHESSBROAD_GRID_SIZE
					* i, CHESSBOARD_WIDTH - CHESSBOARD_RIGHT, CHESSBOARD_TOP
					+ CHESSBROAD_GRID_SIZE * i);
			g.drawLine(CHESSBOARD_LEFT + CHESSBROAD_GRID_SIZE * i,
					CHESSBOARD_TOP, CHESSBOARD_LEFT + CHESSBROAD_GRID_SIZE * i,
					CHESSBOARD_HEIGHT - CHESSBOARD_BOTTOM);
		}

		{// 五个定点
			g.fillOval(CHESSBOARD_LEFT + CHESSBROAD_GRID_SIZE * 9 - 5,
					CHESSBOARD_TOP + CHESSBROAD_GRID_SIZE * 9 - 5, 10, 10);
			g.fillOval(CHESSBOARD_LEFT + CHESSBROAD_GRID_SIZE * 3 - 4,
					CHESSBOARD_TOP + CHESSBROAD_GRID_SIZE * 3 - 4, 8, 8);
			g.fillOval(CHESSBOARD_LEFT + CHESSBROAD_GRID_SIZE * 3 - 4,
					CHESSBOARD_TOP + CHESSBROAD_GRID_SIZE * 15 - 4, 8, 8);
			g.fillOval(CHESSBOARD_LEFT + CHESSBROAD_GRID_SIZE * 15 - 4,
					CHESSBOARD_TOP + CHESSBROAD_GRID_SIZE * 3 - 4, 8, 8);
			g.fillOval(CHESSBOARD_LEFT + CHESSBROAD_GRID_SIZE * 15 - 4,
					CHESSBOARD_TOP + CHESSBROAD_GRID_SIZE * 15 - 4, 8, 8);
		}
		{// 棋盘边框
			// 顶部边框
			g.drawLine(CHESSBOARD_LEFT - 11, CHESSBOARD_TOP - 11,
					CHESSBOARD_WIDTH - CHESSBOARD_RIGHT + 10,
					CHESSBOARD_TOP - 11);
			g.drawLine(CHESSBOARD_LEFT - 10, CHESSBOARD_TOP - 10,
					CHESSBOARD_WIDTH - CHESSBOARD_RIGHT + 11,
					CHESSBOARD_TOP - 10);
			// 底部边框
			g.drawLine(CHESSBOARD_LEFT - 11, CHESSBOARD_HEIGHT
					- CHESSBOARD_BOTTOM + 11, CHESSBOARD_WIDTH
					- CHESSBOARD_RIGHT + 10, CHESSBOARD_HEIGHT
					- CHESSBOARD_BOTTOM + 11);
			g.drawLine(CHESSBOARD_LEFT - 10, CHESSBOARD_HEIGHT
					- CHESSBOARD_BOTTOM + 12, CHESSBOARD_WIDTH
					- CHESSBOARD_RIGHT + 11, CHESSBOARD_HEIGHT
					- CHESSBOARD_BOTTOM + 12);

			g.drawLine(CHESSBOARD_LEFT - 11, CHESSBOARD_TOP - 11,
					CHESSBOARD_LEFT - 11, CHESSBOARD_HEIGHT - CHESSBOARD_BOTTOM
							+ 11);
			g.drawLine(CHESSBOARD_LEFT - 10, CHESSBOARD_TOP - 10,
					CHESSBOARD_LEFT - 10, CHESSBOARD_HEIGHT - CHESSBOARD_BOTTOM
							+ 12);
			// 右边框
			g.drawLine(CHESSBOARD_WIDTH - CHESSBOARD_RIGHT + 10,
					CHESSBOARD_TOP - 11, CHESSBOARD_WIDTH - CHESSBOARD_RIGHT
							+ 10, CHESSBOARD_HEIGHT - CHESSBOARD_BOTTOM + 11);
			g.drawLine(CHESSBOARD_WIDTH - CHESSBOARD_RIGHT + 11,
					CHESSBOARD_TOP - 10, CHESSBOARD_WIDTH - CHESSBOARD_RIGHT
							+ 11, CHESSBOARD_HEIGHT - CHESSBOARD_BOTTOM + 12);
		}

		//保存棋盘
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (GameAction.ChessBox[i][j] == 1)
					g.drawImage(Chess.getInstance().getChess(GameAction.B),
							CHESSBOARD_LEFT + i * CHESSBROAD_GRID_SIZE - CHESSBROAD_GRID_SIZE / 2, CHESSBOARD_TOP + j * CHESSBROAD_GRID_SIZE - CHESSBROAD_GRID_SIZE
									/ 2, CHESSBROAD_GRID_SIZE, CHESSBROAD_GRID_SIZE, this);
				if (GameAction.ChessBox[i][j] == 2)
					g.drawImage(Chess.getInstance().getChess(GameAction.W),
							CHESSBOARD_LEFT + i * CHESSBROAD_GRID_SIZE - CHESSBROAD_GRID_SIZE / 2, CHESSBOARD_TOP + j * CHESSBROAD_GRID_SIZE - CHESSBROAD_GRID_SIZE
									/ 2, CHESSBROAD_GRID_SIZE, CHESSBROAD_GRID_SIZE, this);
			}
		}
		
		
		// 下子
		if (GameAction.GameStar) {
			if (chessFlush) {
				System.out.println("画出子");
				if (tempx != -1 && tempy != -1) {
//					if (Chess.getInstance().setPoint(
//							new Point(240 +tempx
//									* CHESSBROAD_GRID_SIZE
//									- CHESSBROAD_GRID_SIZE / 2, 80
//									+ tempy * CHESSBROAD_GRID_SIZE
//									- CHESSBROAD_GRID_SIZE / 2))) {// �����������
						GameAction.ChessBox[tempx][tempy] = Chess
								.getInstance().getColor(GameAction.who());
						GameAction.makeChess(g);  // ��������
						GameAction.ChessMusic();  // ����������
					//}
				}
			}
		}
	
	}

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		x = e.getX();
		y = e.getY();
		//下棋子
		if ((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0) { // ֻ������
			if (x >= CHESSBOARD_LEFT && y >= CHESSBOARD_TOP && x < +CHESSBOARD_LEFT + 18 * CHESSBROAD_GRID_SIZE
					&& y <= CHESSBOARD_TOP + 18 * CHESSBROAD_GRID_SIZE) {
				if (GameAction.GameStar) {
					System.out.println("可以下子");
					tempx = (x - CHESSBOARD_LEFT + CHESSBROAD_GRID_SIZE / 2) / CHESSBROAD_GRID_SIZE;
					tempy = (y - CHESSBOARD_TOP + CHESSBROAD_GRID_SIZE / 2) / CHESSBROAD_GRID_SIZE;
					if (GameAction.ChessBox[tempx][tempy] == 0) {
						//chessFlush=true;
						repaint();
					}
				} else {
					repaint();
				}
			}
		}
		
		if (e.getX() <= GameAction.height - 40 && e.getY() <= GameAction.width) {
			top = this.getLocationOnScreen();
			first = e.getLocationOnScreen();
			drag = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
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
	public void mouseDragged(MouseEvent e) {
		// TODO 自动生成的方法存根
		
		
		//拖拽
		if (drag) {
			second = e.getLocationOnScreen();
			ChessFrame.getInstance().setLocation(second.x - first.x + top.x,
					second.y - first.y + top.y);
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

}
