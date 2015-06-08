package com.java.anno03;

public class Sample {
	private int x,y;
	
	public Sample(){}
	
	@Anno(su=10 , value=20)
	public void setXY(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public void disp(){
		System.out.println("x : " + x + "y : " + y);
	}
}
