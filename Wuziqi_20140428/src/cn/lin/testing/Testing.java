package cn.lin.testing;

import cn.lin.action.GameAction;
import cn.lin.audio.getAudio;
import cn.lin.chessboard.ChessBoard;
import cn.lin.gameboard.GameFrame;

public class Testing {
	
	public Testing() {
		// TODO 自动生成的构造函数存根
		GameAction.GameStar=true;
		ChessBoard.chessFlush=true;
		GameFrame game = new GameFrame();
		game.getGameFrame_UI();
		
	}
	
	
	public static void main(String[] args) {
		new Testing();
	}
}
