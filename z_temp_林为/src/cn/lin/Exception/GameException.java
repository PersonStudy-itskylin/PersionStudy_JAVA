package cn.lin.Exception;

import javax.swing.JOptionPane;

public class GameException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9376294803590787L;

	public GameException(String msg) {
		// TODO 自动生成的构造函数存根
		super(msg);
		
		//JOptionPane.showConfirmDialog(null, msg,"错误", JOptionPane.ERROR_MESSAGE，JOptionPane.OK_OPTION, null);
		JOptionPane.showMessageDialog(null, msg, "错误提示：", JOptionPane.ERROR_MESSAGE);
	}
}
