package cn.lin.action;

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

import cn.lin.chess.Chess;
import cn.lin.chessboard.ChessFrame;
import cn.lin.gameboard.GameFrame;
import cn.lin.music.Music;
import cn.lin.player.Player;

public class GameAction {
	public static final int width = 645, height = 880, size = 26;
	public static final int locx = height / 2 - size * 9, locy = 70;
	public static Player B = Player.getBInstance();
	public static Player W = Player.getWInstance();
	public static boolean Playermake = false;
	public static boolean GameStar = false;
	public static boolean TimeFlag = false;
	public static int Maxtime = 0;
	//public static BTimeJProgress Btime = new BTimeJProgress();
	//public static WTimeJProgress Wtime = new WTimeJProgress();
	public static int GameAI = 0;
	public static int[][] ChessBox = new int[19][19];

	public GameAction() {
		// TODO 自动生成的构造函数存根
		B.setPlay(true);
		W.setPlay(false);
	}
	
	
	// ����������
	public static void main(String[] args) {
		GameFrame.getInstance();
	}


	//判断谁下子
	public static Player who() {
		if (B.isPlay())
			return B;
		else if (W.isPlay())
			return W;
		else
			return null;
	}

	// ������
	public static void makeChess(Graphics g) {
		if (GameAI == 0) {
			if (who() != null) {
				// ��������
				int x = Chess.getInstance().getPoint().x;
				int y = Chess.getInstance().getPoint().y;
				g.drawImage(Chess.getInstance().getChess(who()), x, y, size,
						size, ChessFrame.getInstance());
				iswin(GameAction.who(), ChessFrame.tempx, ChessFrame.tempy);
				PlayerChange();
			
				
			}

		} else {
			if (!getAIplayer().isPlay()) {
				int x = Chess.getInstance().getPoint().x;
				int y = Chess.getInstance().getPoint().y;
				// ��������
				g.drawImage(Chess.getInstance().getChess(who()), x, y, size,
						size, ChessFrame.getInstance());
				// �ж���Ӯ
				iswin(getAIplayer(), ChessFrame.tempx, ChessFrame.tempy);
				System.out.println("���: " + ChessFrame.tempx + " "
						+ ChessFrame.tempy);
				// ��ѡ��
				PlayerChange();
				
				// ��������
				AImakeChess(g);
			}
		}

	}

	// ����AI������
	public static void AImakeChess(Graphics g) {
		// TODO Auto-generated method stub
		if (GameAI != 0) {
			if (getAIplayer().isPlay()) {
			
			}
		}
	}

	// ������ѡ��
	public static void PlayerChange() {
		B.setPlay(!B.isPlay());// ������״̬
		W.setPlay(!W.isPlay());// ������״̬
	}



	// �ж���Ӯ
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

	// ���ʤ��
	public static void end(Player p) {
		if (ChessFrame.getInstance().musicFlag) {
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
		JOptionPane.showMessageDialog(null, p.getName() + "ʤ��");
		ChessBox = new int[19][19];
	}

	// ���ּ���
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

	// ��ʼ
	public static void startAction() {
		// TODO Auto-generated method stub
		if (GameStar) {
		
		}
	}

	// ����
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

	// ����
	public static void reMakeAction() {
		if (GameAction.GameStar) {
			if (Chess.chessNum != 0) {
				if (GameAction.ChessBox[ChessFrame.tempx][ChessFrame.tempy] != 0) {
					GameAction.ChessBox[ChessFrame.tempx][ChessFrame.tempy] = 0;
					GameAction.B.setPlay(!GameAction.B.isPlay());// ������״̬
					GameAction.W.setPlay(!GameAction.W.isPlay());// ������״̬
					Point p = new Point(-10, -100);
					Chess.getInstance().setPoint(p);
					ChessFrame.chessFlush = false;
					ChessFrame.getInstance().repaint();
					// ChessFrame.chessFlush=true;
				}
			}
		}
	}

	// �˻�
	public static void robotAction() {
		// TODO Auto-generated method stub
		if (true) { // ��������
			GameAI = 1;
			ChessBox[9][9] = 1;
			ChessFrame.getInstance().repaint();
			B.setPlay(false);
			W.setPlay(true);
			GameStar = true;
		} else { // ������� OK
			GameAI = 2;
			GameStar = true;
			B.setPlay(true);
			W.setPlay(false);
		}
		ChessFrame.chessFlush = true;
	}

	// ʱ��
	public static void timeAction() {
		// TODO Auto-generated method stub
		if (GameStar) {
			restart();
			GameStar = false;
		}

		String input = JOptionPane.showInputDialog("��������Ϸ�����ʱ��(��λ:����)");
		try {
			Maxtime = Integer.parseInt(input) * 60;
			if (Maxtime <= 0) {
				JOptionPane.showMessageDialog(null, "������ʱ�����1����");
			} else {
				TimeFlag = true;
				ChessFrame.Btime.setVisible(true);
				ChessFrame.Wtime.setVisible(true);
				ChessFrame.getInstance().repaint();
				// GameAction.Btime.Start();
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "����ȷ����ʱ��!");
		}

	}

	// ����
	public static void saveAction() throws IOException {
		// TODO Auto-generated method stub
		if (GameStar) {
			JFileChooser jfc = new JFileChooser("E:\\temp");
			jfc.setFileSelectionMode(JFileChooser.SAVE_DIALOG
					| JFileChooser.DIRECTORIES_ONLY);
			jfc.setDialogTitle("�������");
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

	// ��ȡ
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


	// AI ��ɫ
	public static Player getAIplayer() {
		// TODO Auto-generated method stub
		if (GameAI == 1)
			return B;
		else
			return W;
	}

	// ���¿�ʼ
	public static void restart() {
		// TODO Auto-generated method stub
		
	}

}
