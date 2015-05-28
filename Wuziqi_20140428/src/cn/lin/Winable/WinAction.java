package cn.lin.Winable;

import cn.lin.chessboard.ChessBoard;
import cn.lin.player.Player;

public class WinAction implements Winable {

	private static WinAction win = new WinAction();
	
	public static WinAction WinAction() {
		// TODO 自动生成的构造函数存根		
		return win;
	}
	public Player win(Player p, int a, int b) {
		// TODO 自动生成的方法存根

			int i = a;
			int j = b;
			int count;
			int m;
			int flag=1;;

			// 判断横向
			for (i = a - 1, j = b, count= 1, m = 1; m <= 4; m++, i--) {
				if (i >= 0 && i < 19 && j >= 0 && j < 19)
					if (ChessBoard.chesses[i][j] == flag)
						count+= 1;
					else
						break;
			}
			for (i = a + 1, j = b, m = 1; m <= 4; m++, i++) {
				if (i >= 0 && i < 19 && j >= 0 && j < 19)
					if (ChessBoard.chesses[i][j] == flag)
						count+= 1;
					else
						break;
			}
			if (count>= 5) {
				return p;
			}

			// 判断纵向
			for (i = a, j = b - 1, count= 1, m = 1; m <= 4; m++, j--) {
				if (i >= 0 && i < 19 && j >= 0 && j < 19)
					if (ChessBoard.chesses[i][j] == flag)
						count+= 1;
					else
						break;
			}
			for (i = a, j = b + 1, m = 1; m <= 4; m++, j++) {
				if (i >= 0 && i < 19 && j >= 0 && j < 19)
					if (ChessBoard.chesses[i][j] == flag)
						count+= 1;
					else
						break;
			}
			if (count>= 5) {
				return p;
			}
			// System.out.println(flag+"左右"+ch);

			// 判断左下
			for (i = a - 1, j = b - 1, count= 1, m = 1; m <= 4; m++, i--, j--) {
				if (i >= 0 && i < 19 && j >= 0 && j < 19)
					if (ChessBoard.chesses[i][j] == flag)
						count+= 1;
					else
						break;
			}
			for (i = a + 1, j = b + 1, m = 1; m <= 4; m++, i++, j++) {
				if (i >= 0 && i < 19 && j >= 0 && j < 19)
					if (ChessBoard.chesses[i][j] == flag)
						count+= 1;
					else
						break;
			}
			if (count>= 5) {
				return p;
			}
			// System.out.println(flag+"左下"+ch);

			// 判断右上
			for (i = a - 1, j = b + 1, count= 1, m = 1; m <= 4; m++, i--, j++) {
				if (i >= 0 && i < 19 && j >= 0 && j < 19)
					if (ChessBoard.chesses[i][j] == flag)
						count+= 1;
			}
			for (i = a + 1, j = b - 1, m = 1; m <= 4; m++, i++, j--) {
				if (i >= 0 && i < 19 && j >= 0 && j < 19)
					if (ChessBoard.chesses[i][j] == flag)
						count+= 1;
			}
			if (count>= 5) {
				return p;
			}
			
			return null;
	}
}
