package fcg;

import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GameAction {
	public static final int width = 645, height = 880, size = 26;
	public static final int locx = height / 2 - size * 9, locy = 70;
	public static Player B = Player.getBInstance();
	public static Player W = Player.getWInstance();
	public static boolean Playermake = false;
	public static boolean GameStar = false;
	public static boolean TimeFlag = false;
	public static int Maxtime = 0;
	public static BTimeJProgress Btime = new BTimeJProgress();
	public static WTimeJProgress Wtime = new WTimeJProgress();
	public static int GameAI = 0;
	static int AIx = 0;
	static int AIy = 0;
	public static int[][] ChessBox = new int[19][19];
	public static int bgNum = 1;

	// 程序主方法
	public static void main(String[] args) {
		starbgMusic();
		B.setPlay(false);
		W.setPlay(false);
		B.setName("诸葛卧龙");
		W.setName("飞凤公瑾");
		GameFrame.getIntance();
	}

	// 启动背景音乐
	public static void starbgMusic() {
		// 背景音乐
		try {
			Music.getMusic().starBGMusic();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 创建玩家
	public static void makePlayer() {
		// TODO Auto-generated method stub

	}

	// 判断谁下棋子
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
		if (GameAI == 0) {
			if (who() != null) {
				// 绘制棋子
				int x = Chess.getInstance().getPoint().x;
				int y = Chess.getInstance().getPoint().y;
				g.drawImage(Chess.getInstance().getChess(who()), x, y, size,
						size, ChessFrame.getInstance());
				// 判断输赢
				iswin(GameAction.who(), ChessFrame.tempx, ChessFrame.tempy);
				// 更换选手
				PlayerChange();
				// 更换时间进度条
				if (TimeFlag) {
					TimeChange();
				}
			}

		} else {
			if (!getAIplayer().isPlay()) {
				int x = Chess.getInstance().getPoint().x;
				int y = Chess.getInstance().getPoint().y;
				// 绘制棋子
				g.drawImage(Chess.getInstance().getChess(who()), x, y, size,
						size, ChessFrame.getInstance());
				// 判断输赢
				iswin(getAIplayer(), ChessFrame.tempx, ChessFrame.tempy);
				System.out.println("玩家: " + ChessFrame.tempx + " "
						+ ChessFrame.tempy);
				// 更换选手
				PlayerChange();
				// 更换时间进度条
				if (TimeFlag)
					TimeChange();
				// 电脑下子
				AImakeChess(g);
			}
		}

	}

	// 电脑AI下棋子
	public static void AImakeChess(Graphics g) {
		// TODO Auto-generated method stub
		if (GameAI != 0) {
			if (getAIplayer().isPlay()) {
				ChessBox[AIx][AIy] = GameAI;
				AI.getInstance().computerDo(0);
				ChessBox[AI.getInstance().getX()][AI.getInstance().getY()] = GameAI;
				System.out.println("电脑下子" + AI.getInstance().getX() + " "
						+ AI.getInstance().getY());

				GameAction.ChessMusic();// 下棋子声音
				// System.out.println("AI下棋X -" + AIx);
				iswin(who(), AIx, AIy);
				PlayerChange();
				if (TimeFlag) {
					TimeChange();
				}
				AIx++;
			}
		}
	}

	// 更换下棋选手
	public static void PlayerChange() {
		B.setPlay(!B.isPlay());// 更改玩家状态
		W.setPlay(!W.isPlay());// 更改玩家状态
	}

	// 更改时间进度条
	public static void TimeChange() {
		// TODO Auto-generated method stub
		if (B.isPlay()) {
			Wtime.Suspend();
			Btime.current();
		} else {
			Btime.Suspend();
			if (WTimeJProgress.flag == false) {
				Wtime.Start();
				WTimeJProgress.flag = true;
			} else {
				Wtime.current();
			}
		}
	}

	// 判断输赢
	public static void iswin(Player p, int a, int b) {
		System.out.println("a " + a + " b " + b);
		ChessFrame.chessFlush = false;
		ChessFrame.getInstance().repaint();
		ChessFrame.chessFlush = true;
		int i = a;
		int j = b;
		int ch;
		int m;
		int flag = Chess.getInstance().getColor(p);

		// 判断横向
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

		// 判断纵向
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
		// System.out.println(flag+"左右"+ch);

		// 判断左下
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
		// System.out.println(flag+"左下"+ch);

		// 判断右上
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

	// 玩家胜利
	public static void end(Player p) {
		if (ChessFrame.musicFlag) {
			try {
				Music.getMusic().starWinMusic();
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		GameStar = false;
		Chess.chessNum = 0;
		GameAI = 0;
		JOptionPane.showMessageDialog(null, p.getName() + "胜利！");
		ChessBox = new int[19][19];
		Btime.timevalue = 0;
		Wtime.timevalue = 0;
		Btime.Suspend();
		Wtime.Suspend();
		ChessFrame.getInstance().Btime.setValue(0);
		ChessFrame.getInstance().Wtime.setValue(0);
	}

	// 音乐加载
	public static void ChessMusic() {
		if (ChessFrame.musicFlag) {
			if (GameAction.B.isPlay()) {
				try {
					Music.getMusic().starBMusic();
				} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					Music.getMusic().starWMusic();
				} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// 开始
	public static void startAction() {
		// TODO Auto-generated method stub
		if (GameStar) {
			restart();
		} else {
			if (Playermake) {
				GameAction.GameStar = true;
				B.setPlay(true);
				W.setPlay(false);
				Btime.timevalue = 0;
				Wtime.timevalue = 0;
				if (TimeFlag) {
					if (BTimeJProgress.flag == false) {
						System.out.println("已启动");
						Btime.Start();
						BTimeJProgress.flag = true;
					} else {
						Btime.current();
					}
				}
			} else {
				new setB();
			}
		}
	}

	// 声音
	public static void SoundAction() {
		if (ChessFrame.musicFlag) {
			Music.getMusic().endBGMusic();
			if (Music.getMusic().Bflag == 1)
				Music.getMusic().endWMusic();
			if (Music.getMusic().Wflag == 1)
				Music.getMusic().endBMusic();
			ChessFrame.musicFlag = false;
		} else {
			try {
				Music.getMusic().starBGMusic();
			} catch (UnsupportedAudioFileException | IOException
					| LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ChessFrame.musicFlag = true;
		}
	}

	// 悔棋
	public static void reMakeAction() {
		if (GameAction.GameStar) {
			if (Chess.chessNum != 0) {
				if (GameAction.ChessBox[ChessFrame.tempx][ChessFrame.tempy] != 0) {
					GameAction.ChessBox[ChessFrame.tempx][ChessFrame.tempy] = 0;
					GameAction.B.setPlay(!GameAction.B.isPlay());// 更改玩家状态
					GameAction.W.setPlay(!GameAction.W.isPlay());// 更改玩家状态
					Point p = new Point(-10, -100);
					Chess.getInstance().setPoint(p);
					ChessFrame.chessFlush = false;
					ChessFrame.getInstance().repaint();
					// ChessFrame.chessFlush=true;
				}
			}
		}
	}

	// 背景
	public static void bgAction() {
		bgNum++;
		if (bgNum == 6)
			bgNum = 1;
		Image.getInstance().setbg(bgNum);
		System.out.println(bgNum);
		ChessFrame.getInstance().repaint();
	}

	// 人机
	public static void robotAction() {
		// TODO Auto-generated method stub
		if (true) { // 电脑先手
			GameAI = 1;
			ChessBox[9][9] = 1;
			ChessFrame.getInstance().repaint();
			B.setPlay(false);
			W.setPlay(true);
			GameStar = true;
		} else { // 玩家先手 OK
			GameAI = 2;
			GameStar = true;
			B.setPlay(true);
			W.setPlay(false);
		}
		ChessFrame.chessFlush = true;
	}

	// 时间
	public static void timeAction() {
		// TODO Auto-generated method stub
		if (GameStar) {
			restart();
			GameStar = false;
		}

		String input = JOptionPane.showInputDialog("请输入游戏的最大时间(单位:分钟)");
		try {
			Maxtime = Integer.parseInt(input) * 60;
			if (Maxtime <= 0) {
				JOptionPane.showMessageDialog(null, "请设置时间大于1分钟");
			} else {
				TimeFlag = true;
				ChessFrame.Btime.setVisible(true);
				ChessFrame.Wtime.setVisible(true);
				ChessFrame.getInstance().repaint();
				// GameAction.Btime.Start();
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "请正确输入时间!");
		}

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
			jfc.showSaveDialog(ChessFrame.getInstance());
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
		jfc.showDialog(ChessFrame.getInstance(), null);
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
		ChessFrame.getInstance().repaint();
		GameStar = true;
		ChessFrame.chessFlush = true;
		System.out.println("flag " + flag);
		if (flag == 1) {
			B.setPlay(true);
			W.setPlay(false);
		} else {
			B.setPlay(false);
			W.setPlay(true);
		}
	}

	// 更改黑方头像
	public static void BTpicActon() {
		// TODO Auto-generated method stub
		Image.BTnum++;
		if (Image.BTnum == 7)
			Image.BTnum = 1;
		ChessFrame.chessFlush = false;
		ChessFrame.getInstance().repaint();
		ChessFrame.chessFlush = true;
	}

	// 更改白方头像
	public static void WTpicActon() {
		// TODO Auto-generated method stub
		Image.WTnum++;
		if (Image.WTnum == 7)
			Image.WTnum = 1;
		ChessFrame.chessFlush = false;
		ChessFrame.getInstance().repaint();
		ChessFrame.chessFlush = true;
	}

	// AI 颜色
	public static Player getAIplayer() {
		// TODO Auto-generated method stub
		if (GameAI == 1)
			return B;
		else
			return W;
	}

	// 从新开始
	public static void restart() {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(ChessFrame.getInstance(),
				"是否重新开始游戏?");
		if (result == 0) {
			GameStar = true;
			B.setPlay(true);
			W.setPlay(false);
			ChessBox = new int[19][19];
			ChessFrame.getInstance().repaint();
			ChessFrame.chessFlush = true;
			System.out.println("00");
		}
	}

}
