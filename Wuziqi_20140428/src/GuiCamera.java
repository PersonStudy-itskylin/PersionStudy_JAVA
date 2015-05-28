import java.awt.AWTException;

import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.Robot;

import java.awt.Toolkit;

import java.awt.image.BufferedImage;

import java.io.File;

import java.io.IOException;

import javax.imageio.ImageIO;

public class GuiCamera {

 

 String fileName="GuiCamera";

 String imageFormat="png";

 int num=0;

 

 Dimension d=Toolkit.getDefaultToolkit().getScreenSize();

 

 public GuiCamera()

 {

 }

 public GuiCamera(String fileName,String imageFormat)

 {

  this.fileName=fileName;

  this.imageFormat=imageFormat;

 }

 public void snpaShot(int startX,int startY,int endX,int endY)

 {

 

  try {

   num++;

   int width=startX>endX?startX-endX:endX-startX;

   int height=startY>endY?startY-endY:endY-startY;

   int temp;

   if(startX>endX)

   {

    temp=startX;

    startX=endX;

    endX=temp;

   }

   if(startY>endY)

   {

    temp=startY;

    startY=endY;

    endY=temp;

   }

//   BufferedImage bImage=(new Robot()).createScreenCapture(new Rectangle(0,0,(int)d.getWidth(),(int)d.getHeight()));

   BufferedImage bImage=(new Robot()).createScreenCapture(new Rectangle(startX,startY,width,height));

   

   String name=fileName+String.valueOf(num)+"."+imageFormat;

   File f=new File(name);

   ImageIO.write(bImage,imageFormat,f);

  } catch (AWTException e) {

   // TODO 自动生成 catch 块

   e.printStackTrace();

  } catch (IOException e) {

   // TODO 自动生成 catch 块

   e.printStackTrace();

  }

 }

 

 

 public static void main(String[] args) {

//  new GuiCamera("d:\\image","png").snpaShot();

 }

 public String getFileName() {

  return fileName;

 }

 public void setFileName(String fileName) {

  this.fileName = fileName;

 }

 public String getImageFormat() {

  return imageFormat;

 }

 public void setImageFormat(String imageFormat) {

  this.imageFormat = imageFormat;

 }

}

 

///////////////////////////////////////////////////////////////

