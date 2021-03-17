package com.iu.s1.util;

public class ActionForward {
	
	private String path;
	private boolean check; //check true 라면 forward, false라면 redirect
	
	public boolean ischeck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check=check;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
}
