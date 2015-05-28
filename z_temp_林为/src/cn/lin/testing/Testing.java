package cn.lin.testing;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import cn.lin.action.GameAction;
import cn.lin.music.Music;

public class Testing {
	public static Music music = Music.getMusic();

	public Testing() {
		// TODO 自动生成的构造函数存根
		GameAction.main();
		try {
			music.starBGMusic();
		} catch (UnsupportedAudioFileException | IOException
				| LineUnavailableException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	// public static void main(String[] args) {
	// new Testing();
	// }
}
