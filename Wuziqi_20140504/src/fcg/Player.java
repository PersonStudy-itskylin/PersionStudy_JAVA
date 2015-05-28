package fcg;

public class Player {
	private String name;
	private boolean play;
	// private int sourse; 可以做积分
	public static Player Bplayer = new Player();
	public static Player Wplayer = new Player();
	public static Player AIplayer = new Player(); // 人机AI

	// 私有构造方法
	private Player() {

	}

	// 黑棋对象
	public static Player getBInstance() {
		return Bplayer;
	}

	// 白棋对象
	public static Player getWInstance() {
		return Wplayer;
	}

	// 电脑对象
	public static Player getAIInstance() {
		return Wplayer;
	}

	// 玩家姓名
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 是否下子状态
	public boolean isPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}

}
