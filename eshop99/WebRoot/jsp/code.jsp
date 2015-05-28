<%@page import="java.awt.Font"%>
<%@ page language="java"  pageEncoding="utf-8"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.Color"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.util.*"%>
<%
//这里将利用Java类来产生一个图片
//1、产生一个宽80，高24的矩形图片背景
BufferedImage buf=new BufferedImage(80,24,BufferedImage.TYPE_INT_RGB);
//2获得一支笔，设置笔的颜色，填充背景
Graphics g=buf.getGraphics();
g.setColor(Color.GRAY);
g.fillRect(0, 0, 80, 24);

//3、调用drawString方法输出数字，注意：需重新设置字体颜色
UUID uuid=UUID.randomUUID();
String num=uuid.toString().substring(0,6);
g.setFont(new Font("宋体",Font.BOLD,18));
g.setColor(Color.ORANGE);
g.drawString(num, 10, 16);


//4、加干扰线drawline
g.setColor(Color.RED);
for(int i=0;i<6;i++){
	Random r1=new Random();
	int x=r1.nextInt(80);
	Random r2=new Random();
	int y=r2.nextInt(24);
	
	Random r3=new Random();
	int x1=r3.nextInt(80);
	Random r4=new Random();
	int y1=r4.nextInt(24);
	
	g.drawLine(x, y,x1, y1);
}

//5输出到客户浏览器

ImageIO.write(buf, "jpg", response.getOutputStream());
pageContext.popBody().clear();
%>