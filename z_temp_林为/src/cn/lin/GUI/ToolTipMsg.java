package cn.lin.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JWindow;

public class ToolTipMsg extends JWindow{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ToolTipUtil1 toolTipUtil;
    private JTextArea msg;
    private Color bgColor;
    private int step = 0;
    boolean flag = true;

    public ToolTipMsg(String str,JFrame frame) {
        super(frame);
        toolTipUtil = new ToolTipUtil1();
        msg = new JTextArea();
         // �趨�߿���ɫ   
        bgColor = new Color(255,255,255); 
        msg.setBackground(bgColor);
        msg.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        msg.setMargin(new Insets(4, 4, 4, 4));   
        msg.setLineWrap(true);   
        msg.setWrapStyleWord(true); 
        msg.setEditable(false);
        setLayout(new BorderLayout());
        msg.setText(str);
        add(msg);
        this.setSize(toolTipUtil.get_width(),toolTipUtil.get_height());
        setAlwaysOnTop(true);
    }

    private synchronized void showMsg_1(int pos){
        int showHeigth = ScreanSizeUtil.getHetgth() - toolTipUtil.get_height() - 30;
        if(!this.isVisible())
            setVisible(true);
        if((showHeigth) <= ScreanSizeUtil.getHetgth() - pos){
            setLocation(ScreanSizeUtil.getWidth() - toolTipUtil.get_width(),
                    ScreanSizeUtil.getHetgth() - pos);
        }else{
            flag = false;
        }
    }

    private synchronized void hiddenMsg_1(int pos){
        if(ScreanSizeUtil.getHetgth() - pos < ScreanSizeUtil.getHetgth()){
            setLocation(ScreanSizeUtil.getWidth() - toolTipUtil.get_width(),
                    ScreanSizeUtil.getHetgth() - pos);
        }else{
            flag = true;
            setVisible(false);
        }
    }

    public void showMsg(){
        new Thread(new Runnable() {

            public void run() {
                if(step < 0)
                    step = 0;
                flag = true;
                while(flag){
                    try {

                        showMsg_1(step);
                        step = step + 5;
                        Thread.sleep(toolTipUtil.get_stepTime());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(!flag){
                        flag = true;
                        break;
                    }
                }
            }
        }).start();
    }
    @Override
    public void paintComponents(Graphics g) {
    	// TODO 自动生成的方法存根
//    	super.paintComponents(g);
    	g.setColor(Color.RED);
    	g.drawRoundRect(300, 100, 200, 200, 45, 45);
    }

    public void hiddenMsg(){
        try {
            Thread.sleep(toolTipUtil.get_displayTime());
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        if(flag){
            flag= false;
        }
            while(step >= 0 && !flag){
                try {
                    Thread.sleep(toolTipUtil.get_stepTime());
                    step = step - 5;
                    hiddenMsg_1(step);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    public static void main(String[] args) {
        ToolTipMsg toolMsg = new ToolTipMsg("fgjsaipnerguipsenguipaebugipabgruipsnbejihgpsnbhtupsibrhi",null);
        toolMsg.showMsg();
        toolMsg.hiddenMsg();
    }
}



 class ToolTipUtil1 {

    // ������ʾ��   
    private int _width = 300;   
    // ������ʾ��   
    private int _height = 100;  
    // �趨ѭ���Ĳ���   
    private int _step = 30;  
    // ÿ��ʱ��   
    private int _stepTime = 30;   
    // ��ʾʱ��   
    private int _displayTime = 6000;   
    // Ŀǰ�����������ʾ����   
    private int _countOfToolTip = 0; 
    // ��ǰ���������   
    private int _maxToolTip = 0;   
    // ����Ļ����ʾ�����������ʾ����   
    private int _maxToolTipSceen; 
    // ����   
    private Font _font;   
    // �߿���ɫ   
    private Color _bgColor;  
    // ������ɫ   
    private Color _border;  
    // ��Ϣ��ɫ   
    private Color _messageColor; 
    // ��ֵ�趨   
    private int _gap;   
    // �Ƿ�Ҫ��������jre1.5���ϰ汾����ִ�У�   
    boolean _useTop = true;
    public int get_width() {
        return _width;
    }
    public void set_width(int _width) {
        this._width = _width;
    }
    public int get_height() {
        return _height;
    }
    public void set_height(int _height) {
        this._height = _height;
    }
    public int get_step() {
        return _step;
    }
    public void set_step(int _step) {
        this._step = _step;
    }
    public int get_stepTime() {
        return _stepTime;
    }
    public void set_stepTime(int _stepTime) {
        this._stepTime = _stepTime;
    }
    public int get_displayTime() {
        return _displayTime;
    }
    public void set_displayTime(int _displayTime) {
        this._displayTime = _displayTime;
    }
    public int get_countOfToolTip() {
        return _countOfToolTip;
    }
    public void set_countOfToolTip(int _countOfToolTip) {
        this._countOfToolTip = _countOfToolTip;
    }
    public int get_maxToolTip() {
        return _maxToolTip;
    }
    public void set_maxToolTip(int _maxToolTip) {
        this._maxToolTip = _maxToolTip;
    }
    public int get_maxToolTipSceen() {
        return _maxToolTipSceen;
    }
    public void set_maxToolTipSceen(int _maxToolTipSceen) {
        this._maxToolTipSceen = _maxToolTipSceen;
    }
    public Font get_font() {
        return _font;
    }
    public void set_font(Font _font) {
        this._font = _font;
    }
    public Color get_bgColor() {
        return _bgColor;
    }
    public void set_bgColor(Color _bgColor) {
        this._bgColor = _bgColor;
    }
    public Color get_border() {
        return _border;
    }
    public void set_border(Color _border) {
        this._border = _border;
    }
    public Color get_messageColor() {
        return _messageColor;
    }
    public void set_messageColor(Color _messageColor) {
        this._messageColor = _messageColor;
    }
    public int get_gap() {
        return _gap;
    }
    public void set_gap(int _gap) {
        this._gap = _gap;
    }
    public boolean is_useTop() {
        return _useTop;
    }
    public void set_useTop(boolean _useTop) {
        this._useTop = _useTop;
    }  

}
