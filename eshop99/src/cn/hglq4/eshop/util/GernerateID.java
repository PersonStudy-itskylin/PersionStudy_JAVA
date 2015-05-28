package cn.hglq4.eshop.util;

import java.util.Random;

public class GernerateID {

	public synchronized static String id(){
		
		String first=DateHelper.format("yyyyMMddhhmmss");
	  
		
		Random r1=new Random();
	    String n1=r1.nextInt(10)+"";
	    
		Random r2=new Random();
	    String n2=r2.nextInt(10)+"";	
		Random r3=new Random();
	    String n3=r3.nextInt(10)+"";
	    
		Random r4=new Random();
	    String n4=r4.nextInt(10)+"";
	    return first+n1+n2+n3+n4;
		
	}


}
