package cn.lin.player;

public class Player {
	private String name;
	private boolean play;
	// private int sourse; ���������
	public static Player Bplayer = new Player();
	public static Player Wplayer = new Player();
	public static Player AIplayer = new Player(); // �˻�AI

	// ˽�й��췽��
	private Player() {

	}

	// �������
	public static Player getBInstance() {
		return Bplayer;
	}

	// �������
	public static Player getWInstance() {
		return Wplayer;
	}

	// ���Զ���
	public static Player getAIInstance() {
		return Wplayer;
	}

	// �������
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// �Ƿ�����״̬
	public boolean isPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}

}
