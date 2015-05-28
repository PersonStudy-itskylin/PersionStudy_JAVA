package cn.lin.action;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import cn.lin.GUI.UIManager;
import cn.lin.chess.Chess;
import cn.lin.chessboard.ChessBoard;
import cn.lin.gameboard.GameFrame;
import cn.lin.player.Player;



public class GameAction implements ActionListener{
	public static boolean GameStar = false;
	public static Player B = Player.getBInstance();
	public static Player W = Player.getWInstance();
	public static int[][] ChessBox=new int[19][19];
	UIManager ui = new UIManager();
	
	public GameAction() {
		// TODO 自动生成的构造函数存根

	}

	// 判断谁下子
	public static Player who() {
		if (B.isPlay())
			return B;
		else if (W.isPlay())
			return W;
		else
			return null;
	}

	// 下棋子
	public static void makeChess(Graphics g) {
		if (who() != null) {
			int x = Chess.getInstance().getPoint().x;
			int y = Chess.getInstance().getPoint().y;
			g.drawImage(Chess.getInstance().getChess(who()), x, y, ChessBoard.CHESSBROAD_GRID_SIZE,  ChessBoard.CHESSBROAD_GRID_SIZE,
					ChessBoard.getInstance());
			iswin(GameAction.who(), ChessBoard.tempx, ChessBoard.tempy);
			PlayerChange();

			ChessBoard.chessFlush=false;
			ChessBoard.getInstance().repaint();
		}
	}

	// 更改下棋选手
	public static void PlayerChange() {
		B.setPlay(!B.isPlay());// ������״̬
		W.setPlay(!W.isPlay());// ������״̬
	}

	//判断输赢
	public static void iswin(Player p, int a, int b) {
		int i = a;
		int j = b;
		int ch;
		int m;
		int flag = Chess.getInstance().getColor(p);

		// �жϺ���
		for (i = a - 1, j = b, ch = 1, m = 1; m <= 4; m++, i--) {
			if (i >= 0 && i < 19 && j >= 0 && j < 19)
				if (ChessBox[i][j] == flag)
					ch += 1;
				else
					break;
		}
		for (i = a + 1, j = b, m = 1; m <= 4; m++, i++) {
			if (i >= 0 && i < 19 && j >= 0 && j < 19)
				if (ChessBox[i][j] == flag)
					ch += 1;
				else
					break;
		}
		if (ch >= 5) {
			end(p);
		}

		// �ж�����
		for (i = a, j = b - 1, ch = 1, m = 1; m <= 4; m++, j--) {
			if (i >= 0 && i < 19 && j >= 0 && j < 19)
				if (ChessBox[i][j] == flag)
					ch += 1;
				else
					break;
		}
		for (i = a, j = b + 1, m = 1; m <= 4; m++, j++) {
			if (i >= 0 && i < 19 && j >= 0 && j < 19)
				if (ChessBox[i][j] == flag)
					ch += 1;
				else
					break;
		}
		if (ch >= 5) {
			end(p);
		}
		// System.out.println(flag+"����"+ch);

		// �ж�����
		for (i = a - 1, j = b - 1, ch = 1, m = 1; m <= 4; m++, i--, j--) {
			if (i >= 0 && i < 19 && j >= 0 && j < 19)
				if (ChessBox[i][j] == flag)
					ch += 1;
				else
					break;
		}
		for (i = a + 1, j = b + 1, m = 1; m <= 4; m++, i++, j++) {
			if (i >= 0 && i < 19 && j >= 0 && j < 19)
				if (ChessBox[i][j] == flag)
					ch += 1;
				else
					break;
		}
		if (ch >= 5) {
			end(p);
		}
		// System.out.println(flag+"����"+ch);

		// �ж�����
		for (i = a - 1, j = b + 1, ch = 1, m = 1; m <= 4; m++, i--, j++) {
			if (i >= 0 && i < 19 && j >= 0 && j < 19)
				if (ChessBox[i][j] == flag)
					ch += 1;
		}
		for (i = a + 1, j = b - 1, m = 1; m <= 4; m++, i++, j--) {
			if (i >= 0 && i < 19 && j >= 0 && j < 19)
				if (ChessBox[i][j] == flag)
					ch += 1;
		}
		if (ch >= 5) {
			end(p);
		}

	}

	
	//玩家胜利
	public static void end(Player p) {
		GameStar = false;
		Chess.chessNum = 0;
		ChessBoard.tempx=-1;
		ChessBoard.tempy=-1;
		ChessBoard.chessFlush=false;
		JOptionPane.showMessageDialog(GameFrame.getInstance(), p.getName() + "胜利！");
		ChessBox = new int[19][19];
		Point w=new Point(-100,-100);
		Chess.getInstance().setPoint(w);
	}
	
	// 保存
	public static void saveAction() throws IOException {
		// TODO Auto-generated method stub
		if (GameStar) {
			JFileChooser jfc = new JFileChooser("E:\\temp");
			jfc.setFileSelectionMode(JFileChooser.SAVE_DIALOG
					| JFileChooser.DIRECTORIES_ONLY);
			jfc.setDialogTitle("保存棋局");
			String saveType[] = { "txt" };
			jfc.setFileFilter(new FileNameExtensionFilter("txt", saveType));
			jfc.showSaveDialog(ChessBoard.getInstance());
			File f = jfc.getSelectedFile();
			String s = f.getPath() + ".txt";
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(s));
				out.write(B.getName());
				out.newLine();
				out.write(W.getName());
				out.newLine();
				if (B.isPlay())
					out.write("1");
				if (W.isPlay())
					out.write("2");
				out.newLine();
				for (int i = 0; i < 19; i++) {
					for (int j = 0; j < 19; j++) {
						if (ChessBox[i][j] != 0) {
							out.write(i + " " + j + " " + ChessBox[i][j]);
							out.newLine();
						}
					}
				}
				out.close();
			} catch (Exception e) {
			}
		}
	}

	// 读取
	public static void readAction() throws IOException {
		// TODO Auto-generated method stub
		int flag = 0;
		JFileChooser jfc = new JFileChooser("E:\\temp");
		String saveType[] = { "txt" };
		jfc.setFileFilter(new FileNameExtensionFilter("txt", saveType));
		jfc.showDialog(ChessBoard.getInstance(), null);
		File f = jfc.getSelectedFile();
		BufferedReader in = new BufferedReader(new FileReader(f));
		B.setName(in.readLine());
		W.setName(in.readLine());
		flag = Integer.parseInt(in.readLine());
		String s;
		while ((s = in.readLine()) != null) {
			String[] num = s.split(" ");// System.out.println(Integer.parseInt(num[0])+" "+Integer.parseInt(num[1])+" "+Integer.parseInt(num[2])
										// );
			ChessBox[Integer.parseInt(num[0])][Integer.parseInt(num[1])] = Integer
					.parseInt(num[2]);
		}
		in.close();
		ChessBoard.getInstance().repaint();
		GameStar = true;
		ChessBoard.chessFlush = true;
		System.out.println("flag " + flag);
		if (flag == 1) {
			B.setPlay(true);
			W.setPlay(false);
		} else {
			B.setPlay(false);
			W.setPlay(true);
		}
	}
	
	
	public static void main() {
		B.setName("黑棋");
		W.setName("白方");
		B.setPlay(true);
		W.setPlay(false);
		GameFrame.getInstance();
	}

	//开始
	public static void starAction(){
		if (GameStar) {
			ChessBox = new int[19][19];
			ChessBoard.getInstance().repaint();
		} else {
			B.setPlay(true);
			W.setPlay(false);
		}
		GameStar=true;
		ChessBoard.chessFlush=true;
	}

	// 悔棋
	public static void reMakeAction() {
		if (GameAction.GameStar) {
			if (Chess.chessNum != 0) {
				if (GameAction.ChessBox[ChessBoard.tempx][ChessBoard.tempy] != 0) {
					GameAction.ChessBox[ChessBoard.tempx][ChessBoard.tempy] = 0;
					GameAction.B.setPlay(!GameAction.B.isPlay());// 更改玩家状态
					GameAction.W.setPlay(!GameAction.W.isPlay());// 更改玩家状态
					Point p = new Point(-100, -100);
					Chess.getInstance().setPoint(p);
					ChessBoard.chessFlush = false;
					ChessBoard.getInstance().repaint();
					//ChessBoard.chessFlush=true;
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		
	}
}
