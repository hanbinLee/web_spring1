package com.java.anno02;

@Anno(id="a" , name="b")
public class Sample {
	private int x,y;
	
	public Sample(){}
	
	public void setXY(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void disp(){
		System.out.println("x : " + x + "y : " + y);
	}
}
