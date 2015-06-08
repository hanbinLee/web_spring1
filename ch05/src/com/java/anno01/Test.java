package com.java.anno01;

public class Test {
	public static void main(String[] args) {
		Sample sample = new Sample();
		sample.setXY(10, 20);
		sample.disp();
		
		Anno anno = sample.getClass().getAnnotation(Anno.class);
		System.out.println("su : " + anno.su());
	}
}
