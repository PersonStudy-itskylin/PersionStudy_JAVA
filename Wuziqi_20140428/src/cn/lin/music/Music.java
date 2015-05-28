package cn.lin.music;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
	private static URL BGurl = null;
	private static URL Burl = null;
	private static URL Wurl = null;
	private static URL Winurl = null;
	private static Clip BGcp;
	private static Clip Bcp;
	private static Clip Wcp;
	private static Clip Wincp;
	private static Music music = new Music();
	public static int Bflag, Wflag, winflag;

	public static Music getMusic() {
		Bflag = 0;
		Wflag = 0;
		BGurl = Music.class.getClassLoader().getResource("Audio/BGmusic.wav");
		// System.out.println(BGurl);
		Burl = Music.class.getClassLoader().getResource("Audio/Bmusic.wav");
		// System.out.println(Burl);
		Wurl = Music.class.getClassLoader().getResource("Audio/Wmusic.wav");
		// System.out.println(Wurl);
		Winurl = Music.class.getClassLoader().getResource("Audio/Winmusic.wav");
		return music;
	}

	public void starBGMusic() throws UnsupportedAudioFileException,
			IOException, LineUnavailableException {
		AudioInputStream BGAI = AudioSystem.getAudioInputStream(BGurl);
		BGcp = AudioSystem.getClip();
		BGcp.open(BGAI);
		BGcp.loop(-1);
	}

	public void endBGMusic() {
		BGcp.stop();
	}

	public void starBMusic() throws UnsupportedAudioFileException, IOException,
			LineUnavailableException {
		AudioInputStream BAI = AudioSystem.getAudioInputStream(Burl);
		Bcp = AudioSystem.getClip();
		Bcp.open(BAI);
		Bcp.start();
		Bflag = 1;
		Wflag = 1;
		winflag = 1;
	}

	public void endBMusic() {
		Bcp.stop();
	}

	public void starWMusic() throws UnsupportedAudioFileException, IOException,
			LineUnavailableException {
		AudioInputStream WAI = AudioSystem.getAudioInputStream(Wurl);
		Wcp = AudioSystem.getClip();
		Wcp.open(WAI);
		Wcp.start();
		Bflag = 1;
		Wflag = 1;
		winflag = 1;
	}

	public void endWMusic() {
		Wcp.stop();
	}

	public void starWinMusic() throws UnsupportedAudioFileException,
			IOException, LineUnavailableException {
		AudioInputStream WinAI = AudioSystem.getAudioInputStream(Winurl);
		Wincp = AudioSystem.getClip();
		Wincp.open(WinAI);
		Wincp.start();
		Bflag = 1;
		Wflag = 1;
		winflag = 1;
	}

	public void endWinMusic() {
		Wincp.stop();
	}

}
