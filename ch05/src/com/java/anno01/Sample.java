package com.java.anno01;

@Anno(su=1)
public class Sample {
	private int x,y;
	
	public Sample() {}
	
	public void setXY(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public void disp(){
		System.out.println("x : " + x + "\t y : " + y);
	}
}
