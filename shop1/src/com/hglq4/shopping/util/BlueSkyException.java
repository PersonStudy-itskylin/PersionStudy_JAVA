package com.hglq4.shopping.util;

@SuppressWarnings("serial")
public class BlueSkyException extends Exception {
	private String resutlMsg;
	
	public BlueSkyException(String resutlMsg){
		this.resutlMsg = resutlMsg;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return resutlMsg;
	}
	
}
